using System;
using System.Linq;

namespace Aut_COMP_HW1_NFA
{
	static class Program
	{
		static public bool Accept(string str)
		{
			var edge = new[,]
			{
				{0, 0, 0, 0, 0, 0},
				{0, 2, 3, 0, 4, 0},
				{5, 0, 0, 0, 0, 0},
				{0, 0, 3, 0, 0, 0},
				{0, 0, 6, 0, 4, 0},
				{0, 0, 0, 0, 0, 0},
				{0, 0, 3, 7, 0, 0},
				{0, 0, 0, 7, 0, 0}
			};

			var final = new[] {false, false, false, true, false, true, true, true};

			var map = new Func<char, int>(x =>
			{
				switch (x)
				{
					case 'f': return 0;
					case 'e': return 1;
					case 'b': return 2;
					case 'c': return 3;
					case 'a': return 4;
					default : return 5;
				}
			});

			if (str != null)
			{
				var state = str.Aggregate(1, (current, c) => edge[current, map(c)]);
				return final[state];
			}
			return false;
		}
		static void Main()
		{
			var str = Console.ReadLine();
			Console.WriteLine(Accept(str) ? "accept" : "reject");
		}
	}
}
