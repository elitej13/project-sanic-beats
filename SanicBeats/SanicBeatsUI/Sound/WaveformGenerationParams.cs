// (c) Copyright Jacob Johnston.
// This source is subject to Microsoft Public License (Ms-PL).
// Please see http://go.microsoft.com/fwlink/?LinkID=131993 for details.
// All other rights reserved.

namespace SanicBeats.Sound
{

    public class WaveformGenerationParams
    {
        public int Points { get; protected set; }
        public string Path { get; protected set; }

        public WaveformGenerationParams(int points, string path)
        {
            Points = points;
            Path = path;
        }

    }
}