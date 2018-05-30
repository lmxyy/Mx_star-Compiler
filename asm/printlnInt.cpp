#include<cstdio>
void printlnInt(int a) {
    if (a == 0) putchar('0');
    if (a < 0) a = -a,putchar('-');
    int num[10],n = 0;
    while (a > 0) num[n++] = a%10,a /= 10;
    for (int i = n-1;i >= 0;--i) putchar('0'+num[i]);
    putchar('\n');
}
