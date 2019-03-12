#include <stdio.h>

int a[10],book[10],n;

//step为第几个箱子 
void dfs(int step) {
	int i; 
	if (step == n+1) {
		for (i = 1; i < n + 1; i++) {
			printf("%d",a[i]);
		}
		printf("\n");
			
		return;
	}
	
	for (i = 1; i <= n; i++) {
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
	scanf("%d",&n);//输入牌数 
	dfs(1);
	getchar();getchar();
	return 0;
}
