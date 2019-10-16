class binarytodecimal{
public static void main(String[]args){
int b=1111;
int a=binary(b);
System.out.println(a);

}

static int binary(int a){
int r=0;
int p=0;
while(a!=0){

r=r+a%10*pow(p,2);
a=a/10;
p++;

}
return r;
}
static int pow(int p,int n){
int pw=1;
while(p>0){
pw=pw*n;
p--;

}

return pw;

}

}