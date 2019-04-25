using SanicBeats.Sound;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
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
using WPFSoundVisualizationLib;

namespace SanicBeats.UI
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        AudioEngine PreInstance;
        AudioEngine PostInstance;

        public MainWindow()
        {
            InitializeComponent();


            PreInstance = new AudioEngine();
            PostInstance = new AudioEngine();


            Helper.Bind(engine, "CanStop", Pause, IsEnabledProperty);
            Helper.Bind(engine, "CanPlay", Play, IsEnabledProperty);

            PreWaveform.RegisterSoundPlayer(engine);
            
        }

        private void OnPlayButtonEvent(object sender, RoutedEventArgs e)
        {

            if (AudioEngine.Instance.CanPlay)
                AudioEngine.Instance.Play();
        }

        private void OnPauseButtonEvent(object sender, RoutedEventArgs e)
        {

            if (AudioEngine.Instance.CanStop)
                AudioEngine.Instance.Stop();
        }

        private void OnExitButtonEvent(object sender, RoutedEventArgs e)
        {
            AudioEngine.Instance.Dispose();
            Close();
        }

        private void OnMouseDownEvent(object sender, MouseButtonEventArgs e)
        {
            if (e.ChangedButton == MouseButton.Left)
                DragMove();
        }

        private void OnTransformApplied(object sender, RoutedEventArgs e)
        {
            var type = (sender as Button)?.Tag.ToString().ToUpper() ?? "NONE";
            switch(type)
            {
                case "FLATTEN":
                    Console.WriteLine("[Info]{MainWindow] Running the flatten transform.");
                    break;

                case "NONE": case "":
                    Console.WriteLine("[Error][MainWindow] No tag was found on the sender, no transform will be applied.");
                    break;
            }
        }
    }
}
