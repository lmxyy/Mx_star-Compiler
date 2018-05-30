#include<cstdio>
char* subString(char* a,int l,int r) {
    char* ret;
    for (int i = l;i <= r;++i)
        ret[i-l] = a[i];
    ret[r-l+1] = 0;
    return ret;
}
