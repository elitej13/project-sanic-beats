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
            var step = 1;
            for (int i = 0; i < raw.Length; i++)
            {
                raw[i] = (byte)(step % 255);
                if (i % 6_300_000 == 0)
                    step += 25;
            }

            var ms = new MemoryStream(raw);
            RawStream = new RawSourceWaveStream(ms, Mp3Stream.WaveFormat);
        }

        public byte[] ReadAllBytes(WaveStream stream)
        {
            var data = new byte[stream.Length];
            stream.Position = 0;
            stream.Read(data, 0, data.Length);
            stream.Position = 0;
            //File.WriteAllBytes("./data.bin", data);
            return data;
        }

        public void WriteAllBytes(byte[] data)
        {
            RawStream.Flush();
            RawStream.Position = 0;
            RawStream.Write(data, 0, data.Length);
        }

    }
}
