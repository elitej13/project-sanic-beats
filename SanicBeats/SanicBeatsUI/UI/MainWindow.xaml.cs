using SanicBeats.Sound;
using SanicBeatsLib;
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

            var data = AudioEngine.LoadedSong.ReadAllBytes(AudioEngine.LoadedSong.RawStream);
            var method = (sender as Button)?.Tag.ToString();
            var transformed = Loader.Transform(method, data);
            Overwrite(ref data, transformed);
            AudioEngine.LoadedSong.WriteAllBytes(data);
            PostInstance.OpenFile();
        }

        private byte[] GetPowerOfTwo(byte[] data)
        {
            var length = 2;
            while (length * 2 < data.Length)
                length *= 2;

            var result = new byte[length];
            for(int i = 0; i < result.Length; i++)
                result[i] = data[i];
            return result;
        }

        private void Overwrite(ref byte[] target, byte[] from)
        {
            for (int i = 0; i < target.Length; i++)
                target[i] = i < from.Length ? from[i] : (byte)0;
        }

    }
}
