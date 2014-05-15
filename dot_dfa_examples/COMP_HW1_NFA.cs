using System;
using System.Linq;

namespace Aut_COMP_HW1_NFA
{
	static class Program
	{
		static void Main()
		{
			var edge = new[,]
			{
				{0, 0, 0, 0, 0, 0},
				{2, 3, 0, 4, 0, 0},
				{2, 5, 0, 0, 0, 0},
				{0, 3, 0, 0, 0, 0},
				{0, 0, 0, 0, 6, 0},
				{0, 3, 7, 0, 0, 0},
				{0, 0, 0, 0, 0, 0},
				{0, 0, 7, 0, 0, 0}
			};

			var final = new[] {false, false, true, false, true, true, true};

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
				var state = str.Aggregate(0, (current, c) => edge[current, map(c)]);
				Console.WriteLine(final[state] ? "accept" : "reject");
			}
		}
	}
}
