using System;
using System.Linq;

namespace Aut_COMP_HW1
{
	static class Program
	{
		static void Main()
		{
			var edge = new[,]
			{
				{0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0},
				{0, 3, 4, 0, 0, 0},
				{0, 3, 0, 0, 0, 0},
				{0, 0, 4, 0, 0, 0},
				{7, 0, 0, 6, 0, 0},
				{0, 0, 0, 0, 1, 0},
				{7, 2, 0, 0, 0, 0}
			};

			var final = new[] {true, true, true, true, false, false, false};

			var map = new Func<char, int>(x =>
			{
				switch (x)
				{
					case 'a': return 0;
					case 'b': return 1;
					case 'c': return 2;
					case 'e': return 3;
					case 'f': return 4;
					default : return 5;
				}
			});

			var str = Console.ReadLine();

			if (str != null)
			{
				var state = str.Aggregate(4, (current, c) => edge[current, map(c)]);
				Console.WriteLine(final[state] ? "accept" : "reject");
			}
		}
	}
}
