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
using HtmlAgilityPack;
using System.Threading;
using System.Net;


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

        private async void Btn1_Click(object sender, RoutedEventArgs e)
        {
            img1.Source = new BitmapImage(new Uri(txtBx3.Text, UriKind.Relative));
            viewBox.Text += txtBx1.Text + " " + txtBx2.Text + "\n";
        }

        private async void GetTimeZone_Click(object sender, RoutedEventArgs e)
        {
            string data = await TimeZoneConnection.LoadTimeZoneAsync(continent.Text, city.Text);
            string[] tmp = Regex.Split(data, @"\s");
            viewBox.Text += city.Text + ": " + tmp[1] +  "\n";
        }


        bool clik = false;
        System.Net.Http.HttpClient httpClient = new System.Net.Http.HttpClient();
        private string DownloadDataFromSite()
        {

            var webSet = new HtmlWeb();
            var doc = webSet.Load("https://24timezones.com/pl_zegar/poland_czas.php");
            HtmlNode hours = doc.DocumentNode.SelectSingleNode("//span[@class='hours']");
            HtmlNode minutes = doc.DocumentNode.SelectSingleNode("//span[@class='minutes']");
            HtmlNode seconds = doc.DocumentNode.SelectSingleNode("//span[@class='seconds']");
            if (hours != null)
            {
                return hours.InnerText + ":" + minutes.InnerText + ":" + seconds.InnerText;
            }
            else
            {
                return "nic";
            }

        }

        private async void Button_Click(object sender, RoutedEventArgs e)
        {
            clik = false;

            while (!clik)
            text_html.Text = await Task.Run(() => DownloadDataFromSite());
            
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            clik = true;
        }
    }
}
