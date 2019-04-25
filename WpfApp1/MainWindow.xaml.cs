using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Data.Entity;
using System.Globalization;

namespace WpfApp1
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        weatherEntities weatherDB;
        System.Windows.Data.CollectionViewSource weather_tableViewSource;
        public MainWindow()
        {
            InitializeComponent();
            weatherDB = new weatherEntities();
        }
        
        private void Btn1_Click(object sender, RoutedEventArgs e)
        {
            img1.Source = new BitmapImage(new Uri(txtBx3.Text, UriKind.Relative));
            viewBox.Text += txtBx1.Text + " " + txtBx2.Text + "\n";
        }

        private async void GetTimeZone_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                string json = await WeatherConnection.LoadTimeZoneAsync(Int32.Parse(lat.Text), Int32.Parse(lon.Text), 10);
                JObject data = JObject.Parse(json);
                var cities = from p in data["list"] select (string)p["name"];
                var weathers = from p in data["list"] select (string)p["weather"][0]["description"];
                viewBox.Text = "";
                for (int i = 0; i < cities.Count(); ++i)
                    viewBox.Text += cities.ElementAt(i) + ":" + weathers.ElementAt(i) + "\n";
            }
            catch (Exception ex)
            {
                viewBox.Text = ex.Message;
            }
        }   
        public void UpdateProgressBlock(string text)
        {
            try
            {
                Application.Current.Dispatcher.Invoke(() =>
                {
                    animTextBlock.Text = text;
                });
            }
            catch { }
        }

        private bool animating = false;
        private System.Threading.Timer waitingAnimationTask;
        private void AnimBtn_Click(object sender, RoutedEventArgs e)
        {
            if (animating)
            {
                animTextBlock.Text = "";
                waitingAnimationTask.Dispose();
                animating = false;
            }
            else
            {
                animating = true;
                waitingAnimationTask =
                new System.Threading.Timer(
                new WroclawWeather(this).UpdateStatus,
                null,
                TimeSpan.FromMilliseconds(0),
                TimeSpan.FromMilliseconds(1000));
            }
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {

            weather_tableViewSource = ((System.Windows.Data.CollectionViewSource)(this.FindResource("weather_tableViewSource")));
            // Load data by setting the CollectionViewSource.Source property:
            // weather_tableViewSource.Source = [generic data source]
            weatherDB.weather_table.Load();
            weather_tableViewSource.Source = weatherDB.weather_table.Local;

            // Load data by setting the CollectionViewSource.Source property:
            // weather_tableViewSource.Source = [generic data source]
        }

        private void DBBtn_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                int maxID = weatherDB.weather_table.Max(p => p.ID);
                weather_table temp = new weather_table()
                {
                    ID = maxID + 1,
                    city = cityTextBox.Text,
                    weather_descr = weather_descrTextBox.Text,
                    temp = Int32.Parse(tempTextBox.Text)
                };
                weatherDB.weather_table.Add(temp);
                weatherDB.SaveChanges();
                weather_tableViewSource.View.Refresh();
            }
            catch (Exception ex)
            {
                viewBox.Text = ex.Message;
            }
        }

        private async void PopulateBtn_Click(object sender, RoutedEventArgs e)
        {
            string json = await WeatherConnection.LoadTimeZoneAsync(33, 113, 50);
            JObject data = JObject.Parse(json);
            var cities = from p in data["list"] select (string)p["name"];
            var weathers = from p in data["list"] select (string)p["weather"][0]["description"];
            var temperature = from p in data["list"] select (string)p["main"]["temp"];

            int maxID = weatherDB.weather_table.Max(p => p.ID);

            for (int i = 0; i < cities.Count(); ++i)
            {
                weather_table temp = new weather_table()
                {
                    ID = ++maxID,
                    city =cities.ElementAt(i),
                    weather_descr = weathers.ElementAt(i),
                   temp = (int)float.Parse(temperature.ElementAt(i), CultureInfo.InvariantCulture.NumberFormat)
                };
                weatherDB.weather_table.Add(temp);
            }
            weatherDB.SaveChanges();
            weather_tableViewSource.View.Refresh();
        }

    }
}
