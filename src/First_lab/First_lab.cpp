// First_lab.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>

#include <cassert>

class Unfair_dice
{
public:
	Unfair_dice(int number_of_sides, double* probability_for_side) {
		assert(number_of_sides, "Negative number of sides");
		this->number_of_sides = number_of_sides;

		this->probability_for_side = new double[number_of_sides];
		double sum_for_checking = 0;//check probabilities input(sum have to be equal to 1)
		for (int i = 0; i < number_of_sides; i++)
		{
			assert(probability_for_side[i], "Negative probability");
			this->probability_for_side[i] = probability_for_side[i];
			sum_for_checking += probability_for_side[i];
		}
		assert(abs(sum_for_checking - 1) < 0.0001, "Sum of probability doesn't be equal to 1");
	};
	~Unfair_dice() {
		delete[] probability_for_side;
	};

private:
	int number_of_sides;
	double* probability_for_side;
};


int main()
{
    
    std::cout << "Hello World!";

}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
