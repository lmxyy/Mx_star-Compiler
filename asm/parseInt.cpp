#include<cstdio>
int parseInt(char* a) {
    int f = 1,st = 0,ret = 0;
    if (a[0] == '-') f = -1,st = 1;
    for (int i = st;a[i] >= '0'&&a[i] <= '9';++i) {
        ret = ret*10+a[i]-'0';
    } 
    return ret*f;
}
