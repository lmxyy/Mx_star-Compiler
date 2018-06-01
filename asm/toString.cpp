#include<malloc.h>
unsigned char* toString(int a) {
    int sign = 0; int len = 0;
    if (a < 0) sign = 1,a = -a;
    int num[12];
    if (a == 0) num[++len] = 0;
    else
    {
	for (;a;a /= 10)
	    num[++len] = a%10;
    }
    unsigned char * ret = (unsigned char*) malloc(len+sign+8);
    (*(long *)ret) = len;
    ret += 8;
    ret[len] = 0;
    for (--len;len >= 0;--len) {
	ret[len] = num[len]+'0';
    }
    return ret-8;
}
