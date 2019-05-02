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


            PreInstance = new AudioEngine(false);
            PostInstance = new AudioEngine(true);

            Import.Engine = PreInstance;


            //Helper.Bind(PreInstance, "CanStop", Pause, IsEnabledProperty);
            //Helper.Bind(PreInstance, "CanPlay", Play, IsEnabledProperty);

            PreWaveform.RegisterSoundPlayer(PreInstance);
            PostWaveform.RegisterSoundPlayer(PostInstance);

            EngineDecider.ValueChanged += EngineDeciderValueChanged;


        }

        private void EngineDeciderValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            Console.WriteLine("Value Changed: " + EngineDecider.Value);
            if (EngineDecider.Value < 0.5)
                EngineDecider.Value = 0;
            else
                EngineDecider.Value = 1;
        }

        private bool ShouldPlayOriginal()
        {
            return (EngineDecider.Value == 0);
        }

        private void OnPlayButtonEvent(object sender, RoutedEventArgs e)
        {
            if (ShouldPlayOriginal())
            {
                PreInstance.Play();
            }
            else
            {
                PostInstance.Play();
            }
        }

        private void OnPauseButtonEvent(object sender, RoutedEventArgs e)
        {
            if (ShouldPlayOriginal())
            {
                PreInstance.Stop();
            }
            else
            {
                PostInstance.Stop();
            }
        }

        private void OnExitButtonEvent(object sender, RoutedEventArgs e)
        {
            PostInstance.Dispose();
            PreInstance.Dispose();
            Close();
        }

        private void OnMouseDownEvent(object sender, MouseButtonEventArgs e)
        {
            if (sender == PreWaveform || sender == PostWaveform)
                return;
            if (e.ChangedButton == MouseButton.Left)
                DragMove();
        }

        private void OnTransformApplied(object sender, RoutedEventArgs e)
        {
            if (!AudioEngine.HasLoaded)
                return;

            var type = (sender as Button)?.Tag.ToString().ToUpper() ?? "NONE";
            switch (type)
            {
                case "FLATTEN":
                    Console.WriteLine("[Info]{MainWindow] Running the flatten transform.");
                    var data = AudioEngine.LoadedSong.ReadAllBytes(AudioEngine.LoadedSong.RawStream);
                    AudioEngine.LoadedSong.WriteAllBytes(data);
                    PostInstance.OpenFile("");
                    break;

                default:
                    Console.WriteLine("[Error][MainWindow] No tag was found on the sender, no transform will be applied.");
                    break;
            }
        }


    }
}
