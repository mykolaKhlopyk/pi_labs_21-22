
#include <iostream>
#include <cassert>
#include <vector>
#include <set>
#include <map>
#include <stdio.h>   
#include <stdlib.h>   
#include <time.h>

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

	Unfair_dice(const Unfair_dice& other) {
		this->number_of_sides = other.number_of_sides;
		this->probability_for_side = new double[other.number_of_sides];
		for (int i = 0; i < this->number_of_sides; i++)
		{
			this->probability_for_side[i] = other.probability_for_side[i];
		}
	}
	
	Unfair_dice operator = (const Unfair_dice& other) {
		this->number_of_sides = other.number_of_sides;
		this->probability_for_side = new double[other.number_of_sides];
		for (int i = 0; i < this->number_of_sides; i++)
		{
			this->probability_for_side[i] = other.probability_for_side[i];
		}
	}

	~Unfair_dice() {
		delete[] probability_for_side;
	};
	int get_number() {
		return number_of_sides;
	}
	double* get_probability_for_side() {
		return probability_for_side;
	}
	void print() {
		std::cout << " n = " << this->number_of_sides << ", probability = {";
		for (int i = 0; i < this->number_of_sides - 1; i++)
		{
			std::cout << " p_" << i << " = " << this->probability_for_side[i] << ",";
		}
		std::cout << " p_" << (this->number_of_sides - 1) << " = " << this->probability_for_side[this->number_of_sides - 1] << "}" << std::endl;
	}
private:
	int number_of_sides;
	double* probability_for_side;
};


Unfair_dice make_random_dice() {

	int possible_numbers[] = { 2,4,6,8,10,12,20 };
	int n = possible_numbers[rand() % 7];
	double* probabilities = new double[n];
	probabilities[n - 1] = 1.0;
	for (int i = 0; i < n - 1; i++)
	{
		probabilities[i] = (rand() % 100) / (n * 100.0);
		probabilities[n - 1] -= probabilities[i];
	}
	Unfair_dice new_dice(n, probabilities);
	delete[]probabilities;

	return new_dice;
}


int main()
{
	srand(time(NULL));
	Unfair_dice a = make_random_dice();
	Unfair_dice b = make_random_dice();

	a.print();
	b.print();
}
