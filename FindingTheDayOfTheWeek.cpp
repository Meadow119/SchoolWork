#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

int main(void) {
	int month, day, year, weekdayNum;

	cout << "Please enter the year in the 20th or 21st century: ";
	cin >> year;
	while (year <= 1901 || year > 2100)
	{
		cout << "You have entered an invalid year number, please try again.";
		cin >> year;
	}

	cout << "Please enter the month number: ";
	cin >> month;
	while (month<=0||month>12)
	{
		cout << "You have entered an invalid month number, please try again.";
		cin >> month;
	}

	cout << "Please enter the day number: ";
	cin >> day;
	while (day <= 0||day>31)
	{
		cout << "You have entered an invalid day number, please try again.";
		cin >> day;
	}



	if (month - 2 <= 0) {
		month = month - 2 + 12;
		year = year - 1;
		month = month * 83;
		month = month / 32;
		month = day + month;
		month = year + month;
		month = month + (year / 4);
		month = month - (year / 100);
		month = month + (year / 400);
		weekdayNum = month % 7;
	}
	else{
		month = month - 2;
		month = month *83;
		month = month / 32;
		month = day + month;
		month = year + month;
		month = month + (year / 4);
		month = month - (year / 100);
		month = month + (year / 400);
		weekdayNum = month % 7;
	}

	string dayofweek;
	if (weekdayNum == 0) {
		dayofweek = "Sunday";
	}
	if (weekdayNum == 1) {
		dayofweek = "Monday";
	}
	if (weekdayNum == 2) {
		dayofweek = "Tuesday";
	}
	if (weekdayNum == 3) {
		dayofweek = "Wednesday";
	}
	if (weekdayNum == 4) {
		dayofweek = "Thursday";
	}
	if (weekdayNum == 5) {
		dayofweek = "Friday";
	}
	if (weekdayNum == 6) {
		dayofweek = "Saturday";
	}

	cout << "Weekday number: "<< weekdayNum<< endl;
	cout << "Day of Week: " <<dayofweek << endl;


	system("pause");
	return 0;
}