#include <iostream>
#include <cmath>

using namespace std;

bool isPrime(int num) {
	int divisionCount = 0;

	for (int i = 2; i < num; i++) {
		if (num%i == 0) {
			divisionCount = divisionCount + 1;
		}
		else {

		}
	}
	if (divisionCount > 0) {
		return false;
	}
	else if (num <= 1) {
		return false;
	}
	else {
		return true;
	}
}


	int main(void) { 
		for (int i = 0; i <= 1000; i++) 
			if (isPrime(i))   cout << i << " ";
		cout << endl;

		system("pause");
		return 0;
	}