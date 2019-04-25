
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WpfApp1
{
    class WroclawWeather
    {
        private MainWindow sender;
        private int current_dots;
        public WroclawWeather(MainWindow sender)
        {
            current_dots = 0;
            this.sender = sender;
        }

        public async void UpdateStatus(Object stateInfo)
        {
            if (current_dots == 3)
                current_dots = 0;
            else
                current_dots++;
            string json = await WeatherConnection.GetWroclawWeather();
            JObject data = JObject.Parse(json);
            string dots = new string('.', current_dots);
            string tmp = "Pogoda we Wroclawiu:" + (string)data["weather"][0]["description"] + ", temperatura:" +
                         (string)data["main"]["temp"] + "[K]" + dots;

            sender.UpdateProgressBlock(tmp);
        }

    }
}