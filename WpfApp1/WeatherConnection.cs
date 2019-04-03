using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace WpfApp1
{
    class WeatherConnection
    {
        public static async Task<string> LoadTimeZoneAsync(int lat, int lon)
        {
            string apiCall = "http://api.openweathermap.org/data/2.5/find?lat="+ lat +"&lon=" + lon+ "&cnt=50&APPID=1201ae5de0411fde4724cc100f99fe58";
            Task<string> result;
            using (HttpClient client = new HttpClient())
            using (HttpResponseMessage response = await client.GetAsync(apiCall))
            using (HttpContent content = response.Content)
            {
                result = content.ReadAsStringAsync();
            }
            return await result;
        }

    }
}
