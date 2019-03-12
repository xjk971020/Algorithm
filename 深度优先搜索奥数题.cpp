#include <stdio.h>
int a[10], book[10];
int total = 0;//表示成功的方案数 

//核心算法 
void dfs(int step) {
	int i;
	if (step == 10) {
		if (a[1]*100 + a[2]*10 + a[3] + a[4]*100 + a[5]*10 + a[6] == a[7]*100 + a[8]*10 + a[9]) {
			total ++;
			printf("%d%d%d + %d%d%d = %d%d%d",a[1],a[2],a[3],a[4],a[5],a[6],a[7],a[8],a[9]);
			printf("\n");
			
		}
		return;
	}
	for (i = 1; i < 10; i++) {
		if (book[i] == 0) {
			a[step] = i;
			book[i] = 1;
			dfs(step+1);
			book[i] = 0;
		}
	}
	return;
} 

int main() {
	dfs(1);
	printf("%d",total/2);
	return 0;
}
