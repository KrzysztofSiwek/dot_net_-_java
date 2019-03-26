using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace WpfApp1
{
    class TimeZoneConnection
    {
        static string apiBaseUrl = "http://worldtimeapi.org/api/timezone/";

        public static async Task<string> LoadTimeZoneAsync(string continent, string city)
        {
            string apiCall = apiBaseUrl + "/" + continent + "/" + city + ".txt";
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
