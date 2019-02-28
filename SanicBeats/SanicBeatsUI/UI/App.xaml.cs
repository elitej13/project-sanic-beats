using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using System.Windows;

namespace SanicBeats.UI
{
    /// <summary>
    /// Interaction logic for App.xaml
    /// </summary>
    public partial class App : Application
    {

        public void OnStartup(object sender, StartupEventArgs e)
        {
            var window = new MainWindow();

            window.Closing += (_, __) => { };

            window.Show();

        }

    }
}
