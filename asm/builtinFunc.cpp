#include<cstdio>
#include<malloc.h>
#include<cstring>

char* stringSubString(char *a,int low,int high) {
    int l = high-low+1;
    char *ret = (char *)malloc(l+1+8);
    *((long*)ret) = l;
    a += low+8;
    ret += 8;
    for (int i = 0;i < l;++i)
	ret[i] = a[i];
    ret[l] = 0;
    return ret-8;
}

int stringParseInt(char *a) {
    a += 8;
    int f = 1,st = 0,ret = 0;
    if (a[0] == '-') f = -1,st = 1;
    for (int i = st;a[i] >= '0'&&a[i] <= '9';++i) {
        ret = ret*10+a[i]-'0';
    } 
    return ret*f;
}

char* stringConcat(char *a,char *b) {
    int now = 0,l1 = *((long *)a),l2 = *((long *)b);
    // printf("%d %d\n",l1,l2);
    char * ret = (char*) malloc(l1+l2+9);
    (*(long *)ret) = l1+l2;
    ret += 8; a += 8; b += 8;
    for (int i = 0;i < l1;++i)
	ret[now++] = a[i];
    for (int i = 0;i < l2;++i)
	ret[now++] = b[i];
    ret[now] = 0;
    return ret-8;
}

int stringEqu(char *a,char *b) {
    return strcmp(a+8,b+8) == 0;
}

int stringLess(char *a,char *b) {
    return strcmp(a+8,b+8) < 0;
}

int stringLeq(char *a,char *b) {
    return strcmp(a+8,b+8) <= 0;
}

void print(char* a) {
    printf("%s",a+8);
}

void println(char* s) {
    puts(s+8);
}

void printInt(int a) {
    if (a == 0) putchar('0');
    if (a < 0) a = -a,putchar('-');
    int num[10],n = 0;
    while (a > 0) num[n++] = a%10,a /= 10;
    for (int i = n-1;i >= 0;--i) putchar('0'+num[i]);
}

void printlnInt(int a) {
    if (a == 0) putchar('0');
    if (a < 0) a = -a,putchar('-');
    int num[10],n = 0;
    while (a > 0) num[n++] = a%10,a /= 10;
    for (int i = n-1;i >= 0;--i) putchar('0'+num[i]);
    putchar('\n');
}

char *getString() {
    char * ret = (char*) malloc(300);
    scanf("%s",ret+8);
    (*(long *)ret) = strlen(ret+8);
    return ret;
}

int getInt()
{
    char ch; int ret = 0,f = 1;
    do ch = getchar(); while (!(ch >= '0'&&ch <= '9')&&ch != '-');
    if (ch == '-') f = -1,ch = getchar();
    do ret = ret*10+ch-'0',ch = getchar(); while (ch >= '0'&&ch <= '9');
    return ret*f;
}

char* toString(int a) {
    int sign = 0; int len = 0;
    if (a < 0) sign = 1,a = -a;
    int num[12];
    if (a == 0) num[++len] = 0;
    else
    {
	for (;a;a /= 10)
	    num[++len] = a%10;
    }
    char * ret = (char*) malloc(len+sign+9);
    (*(long *)ret) = len;
    ret += 8;
    ret[len] = 0;
    for (--len;len >= 0;--len) {
	ret[len] = num[len]+'0';
    }
    return ret-8;
}
