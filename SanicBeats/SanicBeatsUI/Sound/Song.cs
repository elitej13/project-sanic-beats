using NAudio.Wave;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SanicBeats.Sound
{
    public class Song
    {
        
        public WaveStream Mp3Stream;
        public WaveStream RawStream;
        public WaveformGenerationParams WfParams;

        public Song(WaveformGenerationParams wfParams)
        {
            WfParams = wfParams;
            Mp3Stream = new Mp3FileReader(WfParams.Path);


            var raw = ReadAllBytes(Mp3Stream);
            WriteAllBytes(raw);
        }

        public byte[] ReadAllBytes(WaveStream stream)
        {
            var data = new byte[stream.Length];
            stream.Position = 0;
            stream.Read(data, 0, data.Length);
            stream.Position = 0;
            return data;
        }

        public void WriteAllBytes(byte[] data)
        {
            var ms = new MemoryStream(data);
            RawStream = new RawSourceWaveStream(ms, Mp3Stream.WaveFormat);
        }

    }
}
