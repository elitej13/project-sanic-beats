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
        public MainWindow()
        {
            InitializeComponent();

            AudioEngine engine = AudioEngine.Instance;

            Helper.Bind(engine, "CanStop", Pause, IsEnabledProperty);
            Helper.Bind(engine, "CanPlay", Play, IsEnabledProperty);

            WaveForm.RegisterSoundPlayer(engine);
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
    }
}
