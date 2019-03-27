using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WpfApp1
{
    class Animation
    {
        private int maxNumberOfDots;
        private int currentDots;
        private MainWindow sender;


        public Animation(int maxNumberOfDots, MainWindow sender)
        {
            this.maxNumberOfDots = maxNumberOfDots;
            this.sender = sender;
            currentDots = 0;
        }

        public void UpdateStatus(Object stateInfo)
        {

            if (currentDots == maxNumberOfDots)
                currentDots = 0;
            else
                currentDots++;
            string tmp = new string('.', currentDots);
            sender.UpdateProgressBlock(tmp);
        }

    }
}
