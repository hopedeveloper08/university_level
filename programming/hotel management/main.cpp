#include <iostream>
#include <string>
#include <fstream>

using namespace std;

struct hotel {
    string firstName;
    string lastName;
    string phoneNumber;
    string check = "0";
};

int login();

int mainmenu();

int choiseRoom();

void rezerv(hotel room[6]);

int exit();

void cancelRezerv(hotel room[6]);

void status(hotel room[6]);

void selectRoomR(int roomNumber, hotel room[6]);

void selectRoomC(int roomNumber, hotel room[6]);

int login() {
    ifstream FuserIn;
    FuserIn.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\user.txt");
    string pass[2];
    for (int i = 0; i < 2; i++) {
        FuserIn >> pass[i];
    }
    string usernameAdmin;
    string passwordAdmin;
    cout << "username:";
    cin >> usernameAdmin;
    cout << "password:";
    cin >> passwordAdmin;
    if (usernameAdmin == pass[0] && passwordAdmin == pass[1]) {
        return 1;
    } else {
        return 0;
    }
    FuserIn.close();
}

int mainmenu() {
    int mainmenuNumber = 0;
    cout << "mainmenu:" << endl;
    cout << "\t" << "1_Reservation" << endl;
    cout << "\t" << "2_Reservation Cancel" << endl;
    cout << "\t" << "3_Status" << endl;
    cout << "\t" << "4_Change Usename and Password" << endl;
    cout << "\t" << "5_Exit" << endl;
    cout << endl << "Enter The Number:";
    cin >> mainmenuNumber;
    return mainmenuNumber;
}

int choiseRoom() {
    cout << endl << "Enter The Room Number(1/2/3/4/5/6):";
    int roomNumber = 0;
    cin >> roomNumber;
    roomNumber--;
    return roomNumber;
}

int exit() {
    int numExit;
    cout << "finish:" << endl;
    cout << "\t" << "1_Repeat This Step" << endl;
    cout << "\t" << "2_Back To Mainmenu" << endl;
    cout << "\t" << "3_Close Application" << endl;
    cout << endl << "Enter The Number:";
    cin >> numExit;
    return numExit;
}

void setRoom(hotel room[6]) {
    ifstream Fstatus;
    string arr[2];
    string checkRezerv;
    Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\1.txt");
    Fstatus >> checkRezerv;
    if (checkRezerv != "Not") {
        for (int i = 0;i < 2;i++) {
            Fstatus >> arr[i];
        }
        room[0].firstName = checkRezerv;
        room[0].lastName = arr[0];
        room[0].phoneNumber = arr[1];
        room[0].check = "1";
    }
    Fstatus.close();

    Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\2.txt");
    Fstatus >> checkRezerv;
    if (checkRezerv != "Not") {
        for (int i = 0;i < 2;i++) {
            Fstatus >> arr[i];
        }
        room[1].firstName = checkRezerv;
        room[1].lastName = arr[0];
        room[1].phoneNumber = arr[1];
        room[1].check = "1";
    }
    Fstatus.close();

    Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\3.txt");
    Fstatus >> checkRezerv;
    if (checkRezerv != "Not") {
        for (int i = 0;i < 2;i++) {
            Fstatus >> arr[i];
        }
        room[0].firstName = checkRezerv;
        room[2].lastName = arr[0];
        room[2].phoneNumber = arr[1];
        room[2].check = "1";
    }
    Fstatus.close();

    Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\4.txt");
    Fstatus >> checkRezerv;
    if (checkRezerv != "Not") {
        for (int i = 0;i < 2;i++) {
            Fstatus >> arr[i];
        }
        room[0].firstName = checkRezerv;
        room[3].lastName = arr[0];
        room[3].phoneNumber = arr[1];
        room[3].check = "1";
    }
    Fstatus.close();

    Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\5.txt");
    Fstatus >> checkRezerv;
    if (checkRezerv != "Not") {
        for (int i = 0;i < 2;i++) {
            Fstatus >> arr[i];
        }
        room[0].firstName = checkRezerv;
        room[4].lastName = arr[0];
        room[4].phoneNumber = arr[1];
        room[4].check = "1";
    }
    Fstatus.close();

    Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\6.txt");
    Fstatus >> checkRezerv;
    if (checkRezerv != "Not") {
        for (int i = 0;i < 2;i++) {
            Fstatus >> arr[i];
        }
        room[0].firstName = checkRezerv;
        room[5].lastName = arr[0];
        room[5].phoneNumber = arr[1];
        room[5].check = "1";
    }
    Fstatus.close();

}

void selectRoomR (int roomNumber, hotel room[6]) {
    if (roomNumber == 0) {
        ofstream Fstatus;
        Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\1.txt", ios::trunc);
        Fstatus.close();
        Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\1.txt");
        Fstatus << room[roomNumber].firstName << endl;
        Fstatus << room[roomNumber].lastName << endl;
        Fstatus << room[roomNumber].phoneNumber << endl;
        Fstatus.close();
    } else if (roomNumber == 1) {
        ofstream Fstatus;
        Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\2.txt", ios::trunc);
        Fstatus.close();
        Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\2.txt");
        Fstatus << room[roomNumber].firstName << endl;
        Fstatus << room[roomNumber].lastName << endl;
        Fstatus << room[roomNumber].phoneNumber << endl;
        Fstatus.close();
    } else if (roomNumber == 2) {
        ofstream Fstatus;
        Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\3.txt", ios::trunc);
        Fstatus.close();
        Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\3.txt");
        Fstatus << room[roomNumber].firstName << endl;
        Fstatus << room[roomNumber].lastName << endl;
        Fstatus << room[roomNumber].phoneNumber << endl;
        Fstatus.close();
    } else if (roomNumber == 3) {
        ofstream Fstatus;
        Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\4.txt", ios::trunc);
        Fstatus.close();
        Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\4.txt");
        Fstatus << room[roomNumber].firstName << endl;
        Fstatus << room[roomNumber].lastName << endl;
        Fstatus << room[roomNumber].phoneNumber << endl;
        Fstatus.close();
    } else if (roomNumber == 4) {
        ofstream Fstatus;
        Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\5.txt", ios::trunc);
        Fstatus.close();
        Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\5.txt");
        Fstatus << room[roomNumber].firstName << endl;
        Fstatus << room[roomNumber].lastName << endl;
        Fstatus << room[roomNumber].phoneNumber << endl;
        Fstatus.close();
    } else if (roomNumber == 5) {
        ofstream Fstatus;
        Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\6.txt", ios::trunc);
        Fstatus.close();
        Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\6.txt");
        Fstatus << room[roomNumber].firstName << endl;
        Fstatus << room[roomNumber].lastName << endl;
        Fstatus << room[roomNumber].phoneNumber << endl;
        Fstatus.close();
    }
}


void selectRoomC (int roomNumber, hotel room[6]) {
    if (roomNumber == 0) {
        ofstream Fstatus;
        Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\1.txt", ios::trunc);
        Fstatus.close();
        Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\1.txt");
        Fstatus << "Not reserved" << endl;
        Fstatus.close();
    } else if (roomNumber == 1) {
        ofstream Fstatus;
        Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\2.txt", ios::trunc);
        Fstatus.close();
        Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\2.txt");
        Fstatus << "Not reserved" << endl;
        Fstatus.close();
    } else if (roomNumber == 2) {
        ofstream Fstatus;
        Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\3.txt", ios::trunc);
        Fstatus.close();
        Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\3.txt");
        Fstatus << "Not reserved" << endl;
        Fstatus.close();
    } else if (roomNumber == 3) {
        ofstream Fstatus;
        Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\4.txt", ios::trunc);
        Fstatus.close();
        Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\4.txt");
        Fstatus << "Not reserved" << endl;
        Fstatus.close();
    } else if (roomNumber == 4) {
        ofstream Fstatus;
        Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\5.txt", ios::trunc);
        Fstatus.close();
        Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\5.txt");
        Fstatus << "Not reserved" << endl;
        Fstatus.close();
    } else if (roomNumber == 5) {
        ofstream Fstatus;
        Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\6.txt", ios::trunc);
        Fstatus.close();
        Fstatus.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\status\\6.txt");
        Fstatus << "Not reserved" << endl;
        Fstatus.close();
    }
}


void rezerv(hotel room[6]) {
    int roomNumber = choiseRoom();
    if (room[roomNumber].check == "0") {
        cout << "\nEnter firstName : ";
        cin >> room[roomNumber].firstName;
        cout << "\nEnter lastName : ";
        cin >> room[roomNumber].lastName;
        cout << "\nEnter PhoneNumber : ";
        cin >> room[roomNumber].phoneNumber;
        room[roomNumber].check = "1";
        cout << "\nBooked Successfully!" << endl << endl;
        selectRoomR(roomNumber, room);
    } else {
        cout << "\nSorry, This room Is Reserved!" << endl << endl;
    }
}


void cancelRezerv(hotel room[6]) {
    char x;
    int roomNumber = choiseRoom();
    if (room[roomNumber].check != "0") {
        cout << "Are You Sure About Canceling Room( " << roomNumber + 1 << " )Named( " << room[roomNumber].lastName
             << ")(y/n)?";
        cin >> x;
        if (x == 'y') {
            room[roomNumber].check = "0";
            room[roomNumber].firstName = "0";
            room[roomNumber].lastName = "0";
            room[roomNumber].phoneNumber = "0";
            cout << "\nRoom " << roomNumber + 1 << " Was Successfully Cancelled!" << endl << endl;
            selectRoomC(roomNumber, room);
        }
    } else {
        cout << "\nThis Room Has Not Been Reserved!" << endl << endl;
    }
}

void status(hotel room[6]) {
    int roomNumber = choiseRoom();
    if (room[roomNumber].check == "1") {
        cout << "\nName : " << room[roomNumber].firstName << " " << room[roomNumber].lastName;
        cout << "\nPhoneNumber : " << room[roomNumber].phoneNumber << endl << endl;
    } else {
        cout << "\nThis Room Has Not Been Reserved!" << endl << endl;
    }
}

void changeUser() {
    string pass[2];
    if (login() == 1) {
        cout << "Enter The New Username :";
        cin >> pass[0];
        cout << "Enter The New Password :";
        cin >> pass[1];
        ofstream FuserOut;
        FuserOut.open("C:\\Users\\khat ro khat\\Desktop\\code\\c++\\user.txt");
        for (int i = 0; i < 2; i++) {
            FuserOut << pass[i] << endl;
        }
        FuserOut.close();
        cout << "The Change Was Made Successfully" << endl;
        cout << "New Username : " << pass[0];
        cout << "New Password : " << pass[1];
    } else {
        cout << "The username or password is incorrect" << endl;
    }
}

int main() {
    hotel room[6];
    int exitNum = 0;
    int breakLoop;
    setRoom(room);

    if (login() == 1) {

        int mainmenuNumber = 0;
        while (mainmenuNumber != 5) {
            mainmenuNumber = mainmenu();
            breakLoop = 0;

            if (mainmenuNumber == 1) {
                while (breakLoop != 1) {
                    rezerv(room);
                    exitNum = exit();
                    if (exitNum == 1) {
                        continue;
                    } else if (exitNum == 2) {
                        breakLoop = 1;
                    } else if (exitNum == 3) {
                        return 0;
                    }
                }
            } else if (mainmenuNumber == 2) {
                while (breakLoop != 1) {
                    cancelRezerv(room);
                    exitNum = exit();
                    if (exitNum == 1) {
                        continue;
                    } else if (exitNum == 2) {
                        breakLoop = 1;
                    } else if (exitNum == 3) {
                        return 0;
                    }
                }
            } else if (mainmenuNumber == 3) {
                while (breakLoop != 1) {
                    status(room);
                    exitNum = exit();
                    if (exitNum == 1) {
                        continue;
                    } else if (exitNum == 2) {
                        breakLoop = 1;
                    } else if (exitNum == 3) {
                        return 0;
                    }
                }
            } else if (mainmenuNumber == 4) {
                while (breakLoop != 1) {
                    changeUser();
                    exitNum = exit();
                    if (exitNum == 1) {
                        continue;
                    } else if (exitNum == 2) {
                        breakLoop = 1;
                    } else if (exitNum == 3) {
                        return 0;
                    }
                }
            }
        }

    } else {
        cout << "The username or password is incorrect";
    }


    return 0;
}
