#include<cstdio>
#include<cstring>
char * stringConcat(char* a,char *b) {
    char ret[500];
    int l1 = strlen(a),l2 = strlen(b);
    for (int i = 0;i < l1;++i) ret[i] = a[i];
    for (int i = 0;i < l2;++i) ret[l1+i] = b[i];
    ret[l1+l2] = 0;
    return ret;
}
