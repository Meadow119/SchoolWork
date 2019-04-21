#include <string>
#include <iomanip>
#include <iostream>

using namespace std;

class ShopItemOrder {
private:
	string name;
	double unitPrice;
	int itemsOrdered;

public:
	void setName(string x) {
		name = x;
	}
	void setUnitPrice(double y) {
		unitPrice = y;
	}
	void setItemsOrdered(int z) {
		itemsOrdered = z;
	}
	string getName() {
		return name;
	}
	double getUnitPrice() {
		return unitPrice;
	}
	int getItemsOrdered(){
		return itemsOrdered;
	}

	void reciept() {
		cout << "\n----------------------"<<endl;
		cout << "Item: " << name << endl;
		cout << "Cost: " << unitPrice << endl;
		cout << "Amt Ordered: " << itemsOrdered << endl;
		cout << "----------------------" << endl;
		cout<< fixed << setprecision(2) <<"Total: " << unitPrice * itemsOrdered << endl;
	}
};


int main(void) {
	ShopItemOrder item;
	string name;
	double unitPrice;
	int itemsOrdered;

	cout << "Which item would you like to order?" << endl;
	getline(cin, name);
	item.setName(name);

	cout << "What is the unit price?"<<endl;
	cin >> unitPrice;
	item.setUnitPrice(unitPrice);

	cout << "How many would you like?" << endl;
	cin >> itemsOrdered;
	item.setItemsOrdered(itemsOrdered);

	item.reciept();

	system("pause");
	return 0;
}