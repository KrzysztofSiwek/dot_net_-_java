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
            string data = await TimeZoneConnection.LoadTimeZoneAsync(continent.Text, city.Text);
            string[] tmp = Regex.Split(data, @"\s");
            viewBox.Text += city.Text + ": " + tmp[1] +  "\n";
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
