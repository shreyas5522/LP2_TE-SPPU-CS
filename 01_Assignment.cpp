#include <iostream>
#include <cstring>
#include <string>
using namespace std;

int main()
{
    char str[] = "Hello World";
    char str1[11];
    char str2[11];
    int i, len;
    len = strlen(str);
    for (i = 0; i < len; i++)
    {
        str1[i] = str[i] & 127;
        cout << str1[i];
    }
    cout << endl;
    for (i = 0; i < len; i++)
    {
        str2[i] = str[i] ^ 127;
        cout << str2[i];
    }
    cout << endl;
    return 0;
}
