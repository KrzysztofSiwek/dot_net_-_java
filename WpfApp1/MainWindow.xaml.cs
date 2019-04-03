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

namespace WpfApp1
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>

    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Btn1_Click(object sender, RoutedEventArgs e)
        {
            img1.Source = new BitmapImage(new Uri(txtBx3.Text, UriKind.Relative));
            viewBox.Text += txtBx1.Text + " " + txtBx2.Text + "\n";
        }

        private async void GetTimeZone_Click(object sender, RoutedEventArgs e)
        {
            string json = await WeatherConnection.LoadTimeZoneAsync(Int32.Parse(lat.Text), Int32.Parse(lon.Text));
            JObject data = JObject.Parse(json);
            var cities = from p in data["list"] select (string)p["name"];
            var weathers = from p in data["list"] select (string)p["weather"][0]["description"];
            for (int i = 0; i < cities.Count(); ++i)
                viewBox.Text += cities.ElementAt(i) + ":" + weathers.ElementAt(i) + "\n";
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
                new Animation(10, this).UpdateStatus,
                null,
                TimeSpan.FromMilliseconds(0),
                TimeSpan.FromMilliseconds(500));
            }
        }

    }
}
