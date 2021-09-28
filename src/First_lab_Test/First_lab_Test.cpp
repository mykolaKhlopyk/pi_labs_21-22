#include "pch.h"
#include "CppUnitTest.h"
#include "..\First_lab\Sparse_structure.h"
#include "..\First_lab\Unfair_Dice.h"
#include <string>
#include <vector>
#include <map>
using namespace Microsoft::VisualStudio::CppUnitTestFramework;

namespace FirstlabTest
{
	TEST_CLASS(FirstlabTest)
	{
	public:
		
		TEST_METHOD(Test_Sparse_structure_for_int)
		{
			Sparse_list<int> default_list;//();
			Assert::IsTrue(default_list.get_size() == 0);
			Assert::IsTrue(default_list.get_root() == nullptr);

			Sparse_list<int> list(5);//();
			Assert::IsTrue(list.get_size() == 5);
			Assert::IsTrue(list.get_root() == nullptr);
			list.add(5, 4);
			Assert::IsTrue(list[4] == 5);
			Assert::IsTrue(list.get_root()->data == 5);
			Assert::IsTrue((list.positions_by_element(5)).size()==1);

			Sparse_matrix<int> default_matrix;
			Assert::IsTrue(default_matrix.get_m() == 0);
			Assert::IsTrue(default_matrix.get_n() == 0);
			Assert::IsTrue(default_matrix.get_root() == nullptr);

			Sparse_matrix<int> matrix(3,2);//();
			Assert::IsTrue(matrix.get_m() == 3);
			Assert::IsTrue(matrix.get_n() == 2);
			Assert::IsTrue(matrix.get_root() == nullptr);
			matrix.add_to_matrix(4, 0, 0);
			matrix.add_to_matrix(2, 0, 1);
			matrix.add_to_matrix(3, 1, 1);
			matrix.add_to_matrix(5, 1, 0);
			matrix.add_to_matrix(4, 2, 1);
			Assert::IsTrue(matrix.get(2, 0) == 0);
			Assert::IsTrue(matrix.get(1, 1) == 3);
			
			Sparse_matrix<int>sum_matrix = matrix + matrix;
			Sparse_matrix<int>trans_matrix = matrix.transitive();
			Sparse_matrix<int>multiply_matrix = trans_matrix * sum_matrix;
			
			Assert::IsTrue(sum_matrix.get(0, 0) == 8 & sum_matrix.get(0, 1) == 4 &
				sum_matrix.get(1, 0) == 10 & sum_matrix.get(1, 1) == 6 &
				sum_matrix.get(2, 0) == 0 & sum_matrix.get(2, 1) == 8 );
			Assert::IsTrue(multiply_matrix.get(0, 0) == 82 & multiply_matrix.get(0, 1) == 46 &
				multiply_matrix.get(1, 0) == 46 & multiply_matrix.get(1, 1) == 58 );

		}
		TEST_METHOD(Test_Sparse_structure_for_double)
		{
			Sparse_list<double> default_list;//();
			Assert::IsTrue(default_list.get_size() == 0);
			Assert::IsTrue(default_list.get_root() == nullptr);

			Sparse_list<double> list(5);//();
			Assert::IsTrue(list.get_size() == 5);
			Assert::IsTrue(list.get_root() == nullptr);
			list.add(5.6, 4);
			Assert::IsTrue(list[4] == 5.6);
			Assert::IsTrue(list.get_root()->data == 5.6);
		

			Sparse_matrix<double> default_matrix;
			Assert::IsTrue(default_matrix.get_m() == 0);
			Assert::IsTrue(default_matrix.get_n() == 0);
			Assert::IsTrue(default_matrix.get_root() == nullptr);

			Sparse_matrix<double> matrix(3, 2);//();
			Assert::IsTrue(matrix.get_m() == 3);
			Assert::IsTrue(matrix.get_n() == 2);
			Assert::IsTrue(matrix.get_root() == nullptr);
			matrix.add_to_matrix(4, 0, 0);
			matrix.add_to_matrix(2, 0, 1);
			matrix.add_to_matrix(3, 1, 1);
			matrix.add_to_matrix(5, 1, 0);
			matrix.add_to_matrix(4, 2, 1);
			Assert::IsTrue(matrix.get(2, 0) == 0);
			Assert::IsTrue(matrix.get(1, 1) == 3);

			Sparse_matrix<double>sum_matrix = matrix + matrix;
			Sparse_matrix<double>trans_matrix = matrix.transitive();
			Sparse_matrix<double>multiply_matrix = trans_matrix * sum_matrix;

			Assert::IsTrue(sum_matrix.get(0, 0) == 8 & sum_matrix.get(0, 1) == 4 &
				sum_matrix.get(1, 0) == 10 & sum_matrix.get(1, 1) == 6 &
				sum_matrix.get(2, 0) == 0 & sum_matrix.get(2, 1) == 8);
			Assert::IsTrue(multiply_matrix.get(0, 0) == 82 & multiply_matrix.get(0, 1) == 46 &
				multiply_matrix.get(1, 0) == 46 & multiply_matrix.get(1, 1) == 58);

		}
		TEST_METHOD(Test_Sparse_structure_for_string)
		{
			Sparse_list<std::string> default_list;//();
			Assert::IsTrue(default_list.get_size() == 0);
			Assert::IsTrue(default_list.get_root() == nullptr);

			Sparse_list<std::string> list(5);//();
			Assert::IsTrue(list.get_size() == 5);
			Assert::IsTrue(list.get_root() == nullptr);
			list.add("abc", 4);
			Assert::IsTrue(list[4]=="abc");
			Assert::IsTrue(list.get_root()->data == "abc");

			Sparse_matrix<std::string> default_matrix;
			Assert::IsTrue(default_matrix.get_m() == 0);
			Assert::IsTrue(default_matrix.get_n() == 0);
			Assert::IsTrue(default_matrix.get_root() == nullptr);

			Sparse_matrix<std::string> matrix(3, 2);//();
			Assert::IsTrue(matrix.get_m() == 3);
			Assert::IsTrue(matrix.get_n() == 2);
			Assert::IsTrue(matrix.get_root() == nullptr);
			matrix.add_to_matrix("a", 0, 0);
			matrix.add_to_matrix("b", 0, 1);
			matrix.add_to_matrix("d", 1, 1);
			matrix.add_to_matrix("c", 1, 0);
			matrix.add_to_matrix("f", 2, 1);
			Assert::IsTrue(matrix.get(0, 0) == "a" & matrix.get(0, 1) == "b" &
				matrix.get(1, 0) == "c" & matrix.get(1, 1) == "d" &
				matrix.get(2, 1) == "f");
		}
		TEST_METHOD(Test_Sparse_structure_for_Unfair_dice)
		{
			Sparse_list<Unfair_dice> default_list;//();
			Assert::IsTrue(default_list.get_size() == 0);
			Assert::IsTrue(default_list.get_root() == nullptr);

			Sparse_list<Unfair_dice> list(5);//();
			Assert::IsTrue(list.get_size() == 5);
			Assert::IsTrue(list.get_root() == nullptr);
			Unfair_dice a = make_random_dice();
			list.add(a, 4);
			Assert::IsTrue(list.get_root() != nullptr);
		

			
		}
		TEST_METHOD(Test_Unfair_dice)
		{
			int n = 4;
			double* properties = new double[n];
			properties[0] = 0;
			properties[1] = 0.5;
			properties[2] = 0.2;
			properties[3] = 0.3;

			Unfair_dice a(n, properties);
			Assert::IsTrue(a.get_number()==n && a.get_probability_for_side()[2]==0.2);
			std::vector<Unfair_dice>set = { a,a };
			std::map <int, double> result = find_all_combination_sum(set);
			Assert::IsTrue(abs(result[4] - 0.25) < 0.0001 &
				abs(result[5] - 0.2) < 0.0001 & abs(result[6]-0.34) < 0.0001 &
					abs(result[7] - 0.12) < 0.0001 & abs(result[8] - 0.09) < 0.0001);



		}

	};
}
