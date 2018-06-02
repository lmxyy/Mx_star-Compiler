global main

extern malloc
section .text

___origin:
___origin..origin.entry:
	push rbp
	mov rbp,rsp
	sub rsp,224
	mov qword [rbp-64],rdi
	mov r8,qword [___i]
	mov qword [rbp-80],r8
	mov r8,qword [___make]
	mov qword [rbp-120],r8
	mov r8,qword [___j]
	mov qword [rbp-72],r8
	mov r8,qword [rbp-64]
	mov r9,r8
	mov qword [rbp-104],r9
	mov r8,qword [rbp-104]
	imul r8,8
	mov qword [rbp-104],r8
	mov r8,qword [rbp-104]
	mov r9,r8
	mov qword [rbp-136],r9
	mov r8,qword [rbp-136]
	add r8,8
	mov qword [rbp-136],r8
	mov r8,qword [rbp-136]
	mov rdi,r8
	call malloc
	mov rdi,qword [rbp-64]
	mov r8,rax
	mov qword [rbp-136],r8
	mov qword [rbp-64],rdi
	mov r8,qword [rbp-136]
	mov r9,qword [rbp-64]
	mov qword [r8],r9
	mov r8,qword [rbp-136]
	mov r9,r8
	mov qword [rbp-120],r9
	mov r8,0
	mov qword [rbp-80],r8
	jmp ___origin..for_cond
___origin..for_cond:
	mov r8,qword [rbp-80]
	mov r9,qword [rbp-64]
	cmp r8,r9
	mov r10,0
	setl r10b
	mov qword [rbp-8],r10
	mov r8,qword [rbp-8]
	cmp r8b,1
	jz ___origin..for_loop
	jnz ___origin..for_after
___origin..for_loop:
	mov r8,qword [rbp-64]
	mov r9,r8
	mov qword [rbp-48],r9
	mov r8,qword [rbp-48]
	imul r8,8
	mov qword [rbp-48],r8
	mov r8,qword [rbp-48]
	mov r9,r8
	mov qword [rbp-128],r9
	mov r8,qword [rbp-128]
	add r8,8
	mov qword [rbp-128],r8
	mov r8,qword [rbp-128]
	mov rdi,r8
	call malloc
	mov rdi,qword [rbp-64]
	mov r8,rax
	mov qword [rbp-128],r8
	mov qword [rbp-64],rdi
	mov r8,qword [rbp-128]
	mov r9,qword [rbp-64]
	mov qword [r8],r9
	mov r8,qword [rbp-80]
	mov r9,r8
	mov qword [rbp-56],r9
	mov r8,qword [rbp-56]
	imul r8,8
	mov qword [rbp-56],r8
	mov r8,qword [rbp-56]
	mov r9,r8
	mov qword [rbp-16],r9
	mov r8,qword [rbp-120]
	mov r9,qword [rbp-16]
	add r9,r8
	mov qword [rbp-16],r9
	mov r8,qword [rbp-16]
	mov r9,qword [rbp-128]
	mov qword [r8+8],r9
	mov r8,0
	mov qword [rbp-72],r8
	jmp ___origin..for_cond_2
___origin..for_cond_2:
	mov r8,qword [rbp-72]
	mov r9,qword [rbp-64]
	cmp r8,r9
	mov r10,0
	setl r10b
	mov qword [rbp-112],r10
	mov r8,qword [rbp-112]
	cmp r8b,1
	jz ___origin..for_loop_2
	jnz ___origin..for_after_2
___origin..for_loop_2:
	mov r8,qword [rbp-80]
	mov r9,r8
	mov qword [rbp-24],r9
	mov r8,qword [rbp-24]
	imul r8,8
	mov qword [rbp-24],r8
	mov r8,qword [rbp-24]
	mov r9,r8
	mov qword [rbp-88],r9
	mov r8,qword [rbp-120]
	mov r9,qword [rbp-88]
	add r9,r8
	mov qword [rbp-88],r9
	mov r8,qword [rbp-88]
	mov r8,qword [r8+8]
	mov qword [rbp-88],r8
	mov r8,qword [rbp-72]
	mov r9,r8
	mov qword [rbp-32],r9
	mov r8,qword [rbp-32]
	imul r8,8
	mov qword [rbp-32],r8
	mov r8,qword [rbp-32]
	mov r9,r8
	mov qword [rbp-40],r9
	mov r8,qword [rbp-88]
	mov r9,qword [rbp-40]
	add r9,r8
	mov qword [rbp-40],r9
	mov r8,qword [rbp-40]
	mov qword [r8+8],0
	jmp ___origin..for_step
___origin..for_step:
	mov r8,qword [rbp-72]
	mov r9,r8
	mov qword [rbp-144],r9
	mov r8,qword [rbp-72]
	add r8,1
	mov qword [rbp-72],r8
	jmp ___origin..for_cond_2
___origin..for_after_2:
	jmp ___origin..for_step_2
___origin..for_step_2:
	mov r8,qword [rbp-80]
	mov r9,r8
	mov qword [rbp-96],r9
	mov r8,qword [rbp-80]
	add r8,1
	mov qword [rbp-80],r8
	jmp ___origin..for_cond
___origin..for_after:
	mov r8,qword [rbp-80]
	mov qword [___i],r8
	mov r8,qword [rbp-120]
	mov qword [___make],r8
	mov r8,qword [rbp-72]
	mov qword [___j],r8
	leave
	ret

___search:
___search..search.entry:
	push rbp
	mov rbp,rsp
	sub rsp,2464
	mov qword [rbp-1760],rdi
	mov qword [rbp-1544],rsi
	mov qword [rbp-1112],rdx
	mov r8,qword [___count]
	mov qword [rbp-288],r8
	mov r8,qword [___make]
	mov qword [rbp-840],r8
	mov r8,___string
	mov qword [rbp-16],r8
	mov r8,qword [___color]
	mov qword [rbp-1840],r8
	mov r8,___string_2
	mov qword [rbp-1832],r8
	mov r8,0
	mov qword [rbp-856],r8
	mov r8,0
	mov qword [rbp-472],r8
	mov r8,0
	mov qword [rbp-1000],r8
	mov r8,qword [rbp-1544]
	cmp r8,0
	mov r9,0
	setg r9b
	mov qword [rbp-152],r9
	mov r8,qword [rbp-152]
	cmp r8b,1
	jz ___search..lhs_true
	jnz ___search..lhs_false
___search..lhs_false:
	mov r8,qword [rbp-1544]
	cmp r8,0
	mov r9,0
	setl r9b
	mov qword [rbp-1296],r9
	mov r8,qword [rbp-1296]
	mov r9,r8
	mov qword [rbp-2072],r9
	jmp ___search..lhs_merge
___search..lhs_true:
	mov r8,1
	mov qword [rbp-2072],r8
	jmp ___search..lhs_merge
___search..lhs_merge:
	mov r8,qword [rbp-2072]
	cmp r8b,1
	jz ___search..lhs_true_2
	jnz ___search..lhs_false_2
___search..lhs_true_2:
	mov r8,1
	mov qword [rbp-272],r8
	jmp ___search..lhs_merge_2
___search..lhs_false_2:
	mov r8,qword [rbp-1760]
	cmp r8,0
	mov r9,0
	sete r9b
	mov qword [rbp-696],r9
	mov r8,qword [rbp-696]
	mov r9,r8
	mov qword [rbp-272],r9
	jmp ___search..lhs_merge_2
___search..lhs_merge_2:
	mov r8,qword [rbp-272]
	cmp r8b,1
	jz ___search..lhs_true_3
	jnz ___search..lhs_false_3
___search..lhs_false_3:
	mov r8,qword [rbp-1760]
	mov r9,r8
	mov qword [rbp-1976],r9
	mov r8,qword [rbp-1976]
	sub r8,1
	mov qword [rbp-1976],r8
	mov r8,qword [rbp-1976]
	mov r9,r8
	mov qword [rbp-1736],r9
	mov r8,qword [rbp-1736]
	mov r9,r8
	mov qword [rbp-1600],r9
	mov r8,qword [rbp-1600]
	imul r8,8
	mov qword [rbp-1600],r8
	mov r8,qword [rbp-1600]
	mov r9,r8
	mov qword [rbp-1248],r9
	mov r8,qword [rbp-840]
	mov r9,qword [rbp-1248]
	add r9,r8
	mov qword [rbp-1248],r9
	mov r8,qword [rbp-1248]
	mov r8,qword [r8+8]
	mov qword [rbp-1248],r8
	mov r8,qword [rbp-1248]
	mov r9,r8
	mov qword [rbp-1024],r9
	mov r8,qword [rbp-1024]
	add r8,0
	mov qword [rbp-1024],r8
	mov r8,qword [rbp-1024]
	mov r9,r8
	mov qword [rbp-2312],r9
	mov r8,qword [rbp-2312]
	mov r8,qword [r8+8]
	mov qword [rbp-2312],r8
	mov r8,qword [rbp-1760]
	mov r9,r8
	mov qword [rbp-808],r9
	mov r8,qword [rbp-808]
	sub r8,1
	mov qword [rbp-808],r8
	mov r8,qword [rbp-808]
	mov r9,r8
	mov qword [rbp-1176],r9
	mov r8,qword [rbp-1176]
	mov r9,r8
	mov qword [rbp-2128],r9
	mov r8,qword [rbp-2128]
	imul r8,8
	mov qword [rbp-2128],r8
	mov r8,qword [rbp-2128]
	mov r9,r8
	mov qword [rbp-1904],r9
	mov r8,qword [rbp-840]
	mov r9,qword [rbp-1904]
	add r9,r8
	mov qword [rbp-1904],r9
	mov r8,qword [rbp-1904]
	mov r8,qword [r8+8]
	mov qword [rbp-1904],r8
	mov r8,qword [rbp-1904]
	mov r9,r8
	mov qword [rbp-1392],r9
	mov r8,qword [rbp-1392]
	add r8,8
	mov qword [rbp-1392],r8
	mov r8,qword [rbp-1392]
	mov r9,r8
	mov qword [rbp-376],r9
	mov r8,qword [rbp-376]
	mov r8,qword [r8+8]
	mov qword [rbp-376],r8
	mov r8,qword [rbp-2312]
	mov r9,r8
	mov qword [rbp-224],r9
	mov r8,qword [rbp-376]
	mov r9,qword [rbp-224]
	add r9,r8
	mov qword [rbp-224],r9
	mov r8,qword [rbp-224]
	mov r9,r8
	mov qword [rbp-2136],r9
	mov r8,qword [rbp-1760]
	mov r9,r8
	mov qword [rbp-1792],r9
	mov r8,qword [rbp-1792]
	sub r8,1
	mov qword [rbp-1792],r8
	mov r8,qword [rbp-1792]
	mov r9,r8
	mov qword [rbp-1416],r9
	mov r8,qword [rbp-1416]
	mov r9,r8
	mov qword [rbp-1592],r9
	mov r8,qword [rbp-1592]
	imul r8,8
	mov qword [rbp-1592],r8
	mov r8,qword [rbp-1592]
	mov r9,r8
	mov qword [rbp-2016],r9
	mov r8,qword [rbp-840]
	mov r9,qword [rbp-2016]
	add r9,r8
	mov qword [rbp-2016],r9
	mov r8,qword [rbp-2016]
	mov r8,qword [r8+8]
	mov qword [rbp-2016],r8
	mov r8,qword [rbp-2016]
	mov r9,r8
	mov qword [rbp-2192],r9
	mov r8,qword [rbp-2192]
	add r8,16
	mov qword [rbp-2192],r8
	mov r8,qword [rbp-2192]
	mov r9,r8
	mov qword [rbp-1120],r9
	mov r8,qword [rbp-1120]
	mov r8,qword [r8+8]
	mov qword [rbp-1120],r8
	mov r8,qword [rbp-2136]
	mov r9,r8
	mov qword [rbp-400],r9
	mov r8,qword [rbp-1120]
	mov r9,qword [rbp-400]
	add r9,r8
	mov qword [rbp-400],r9
	mov r8,qword [rbp-400]
	mov r9,r8
	mov qword [rbp-1368],r9
	mov r8,qword [rbp-1368]
	cmp r8,15
	mov r9,0
	sete r9b
	mov qword [rbp-1192],r9
	mov r8,qword [rbp-1192]
	mov r9,r8
	mov qword [rbp-1912],r9
	jmp ___search..lhs_merge_3
___search..lhs_true_3:
	mov r8,1
	mov qword [rbp-1912],r8
	jmp ___search..lhs_merge_3
___search..lhs_merge_3:
	mov r8,qword [rbp-1912]
	cmp r8b,1
	jz ___search..if_true
	jnz ___search..if_after
___search..if_true:
	mov r8,qword [rbp-1760]
	cmp r8,2
	mov r9,0
	sete r9b
	mov qword [rbp-960],r9
	mov r8,qword [rbp-960]
	cmp r8b,1
	jz ___search..lhs_true_4
	jnz ___search..lhs_false_4
___search..lhs_false_4:
	mov r8,0
	mov qword [rbp-416],r8
	jmp ___search..lhs_merge_4
___search..lhs_true_4:
	mov r8,qword [rbp-1544]
	cmp r8,2
	mov r9,0
	sete r9b
	mov qword [rbp-1200],r9
	mov r8,qword [rbp-1200]
	mov r9,r8
	mov qword [rbp-416],r9
	jmp ___search..lhs_merge_4
___search..lhs_merge_4:
	mov r8,qword [rbp-416]
	cmp r8b,1
	jz ___search..if_true_2
	jnz ___search..if_false
___search..if_false:
	mov r8,qword [rbp-1544]
	cmp r8,2
	mov r9,0
	sete r9b
	mov qword [rbp-1856],r9
	mov r8,qword [rbp-1856]
	cmp r8b,1
	jz ___search..if_true_3
	jnz ___search..if_false_2
___search..if_false_2:
	mov r8,1
	mov qword [rbp-472],r8
	jmp ___search..for_cond
___search..for_cond:
	mov r8,qword [rbp-472]
	cmp r8,9
	mov r9,0
	setle r9b
	mov qword [rbp-1288],r9
	mov r8,qword [rbp-1288]
	cmp r8b,1
	jz ___search..for_loop
	jnz ___search..for_after
___search..for_loop:
	mov r8,qword [rbp-472]
	mov r9,r8
	mov qword [rbp-984],r9
	mov r8,qword [rbp-984]
	imul r8,8
	mov qword [rbp-984],r8
	mov r8,qword [rbp-984]
	mov r9,r8
	mov qword [rbp-144],r9
	mov r8,qword [rbp-1840]
	mov r9,qword [rbp-144]
	add r9,r8
	mov qword [rbp-144],r9
	mov r8,qword [rbp-144]
	mov r8,qword [r8+8]
	mov qword [rbp-144],r8
	mov r8,qword [rbp-144]
	cmp r8,0
	mov r9,0
	sete r9b
	mov qword [rbp-1608],r9
	mov r8,qword [rbp-1608]
	cmp r8b,1
	jz ___search..if_true_4
	jnz ___search..if_after_2
___search..if_true_4:
	mov r8,qword [rbp-472]
	mov r9,r8
	mov qword [rbp-1104],r9
	mov r8,qword [rbp-1104]
	imul r8,8
	mov qword [rbp-1104],r8
	mov r8,qword [rbp-1104]
	mov r9,r8
	mov qword [rbp-1504],r9
	mov r8,qword [rbp-1840]
	mov r9,qword [rbp-1504]
	add r9,r8
	mov qword [rbp-1504],r9
	mov r8,qword [rbp-1504]
	mov qword [r8+8],1
	mov r8,qword [rbp-1760]
	mov r9,r8
	mov qword [rbp-1696],r9
	mov r8,qword [rbp-1696]
	imul r8,8
	mov qword [rbp-1696],r8
	mov r8,qword [rbp-1696]
	mov r9,r8
	mov qword [rbp-488],r9
	mov r8,qword [rbp-840]
	mov r9,qword [rbp-488]
	add r9,r8
	mov qword [rbp-488],r9
	mov r8,qword [rbp-488]
	mov r8,qword [r8+8]
	mov qword [rbp-488],r8
	mov r8,qword [rbp-1544]
	mov r9,r8
	mov qword [rbp-568],r9
	mov r8,qword [rbp-568]
	imul r8,8
	mov qword [rbp-568],r8
	mov r8,qword [rbp-568]
	mov r9,r8
	mov qword [rbp-2360],r9
	mov r8,qword [rbp-488]
	mov r9,qword [rbp-2360]
	add r9,r8
	mov qword [rbp-2360],r9
	mov r8,qword [rbp-2360]
	mov r9,qword [rbp-472]
	mov qword [r8+8],r9
	mov r8,qword [rbp-1544]
	cmp r8,2
	mov r9,0
	sete r9b
	mov qword [rbp-1336],r9
	mov r8,qword [rbp-1336]
	cmp r8b,1
	jz ___search..if_true_5
	jnz ___search..if_false_3
___search..if_true_5:
	mov r8,qword [rbp-1760]
	mov r9,r8
	mov qword [rbp-1680],r9
	mov r8,qword [rbp-1680]
	add r8,1
	mov qword [rbp-1680],r8
	mov r8,qword [rbp-1680]
	mov r9,r8
	mov qword [rbp-1968],r9
	mov r8,qword [rbp-1112]
	mov r9,r8
	mov qword [rbp-2080],r9
	mov r8,qword [rbp-472]
	mov r9,qword [rbp-2080]
	add r9,r8
	mov qword [rbp-2080],r9
	mov r8,qword [rbp-2080]
	mov r9,r8
	mov qword [rbp-2264],r9
	mov qword [rbp-2400],r8
	mov qword [rbp-2408],r10
	mov qword [rbp-2416],r9
	mov qword [rbp-2424],rdi
	mov qword [rbp-2432],rsi
	mov qword [rbp-2440],rdx
	mov rdx,qword [rbp-2264]
	mov rsi,0
	mov rdi,qword [rbp-1968]
	call ___search
	mov rdx,qword [rbp-2440]
	mov rsi,qword [rbp-2432]
	mov rdi,qword [rbp-2424]
	mov r9,qword [rbp-2416]
	mov r10,qword [rbp-2408]
	mov r8,qword [rbp-2400]
	mov r8,rax
	mov qword [rbp-1128],r8
	jmp ___search..if_after_3
___search..if_false_3:
	mov r8,qword [rbp-1544]
	mov r9,r8
	mov qword [rbp-792],r9
	mov r8,qword [rbp-792]
	add r8,1
	mov qword [rbp-792],r8
	mov r8,qword [rbp-792]
	mov r9,r8
	mov qword [rbp-1952],r9
	mov r8,qword [rbp-1112]
	mov r9,r8
	mov qword [rbp-2232],r9
	mov r8,qword [rbp-472]
	mov r9,qword [rbp-2232]
	add r9,r8
	mov qword [rbp-2232],r9
	mov r8,qword [rbp-2232]
	mov r9,r8
	mov qword [rbp-1672],r9
	mov qword [rbp-2400],r8
	mov qword [rbp-2408],r10
	mov qword [rbp-2416],r9
	mov qword [rbp-2424],rdi
	mov qword [rbp-2432],rsi
	mov qword [rbp-2440],rdx
	mov rdx,qword [rbp-1672]
	mov rsi,qword [rbp-1952]
	mov rdi,qword [rbp-1760]
	call ___search
	mov rdx,qword [rbp-2440]
	mov rsi,qword [rbp-2432]
	mov rdi,qword [rbp-2424]
	mov r9,qword [rbp-2416]
	mov r10,qword [rbp-2408]
	mov r8,qword [rbp-2400]
	mov r8,rax
	mov qword [rbp-560],r8
	jmp ___search..if_after_3
___search..if_after_3:
	mov r8,qword [rbp-1760]
	mov r9,r8
	mov qword [rbp-32],r9
	mov r8,qword [rbp-32]
	imul r8,8
	mov qword [rbp-32],r8
	mov r8,qword [rbp-32]
	mov r9,r8
	mov qword [rbp-976],r9
	mov r8,qword [rbp-840]
	mov r9,qword [rbp-976]
	add r9,r8
	mov qword [rbp-976],r9
	mov r8,qword [rbp-976]
	mov r8,qword [r8+8]
	mov qword [rbp-976],r8
	mov r8,qword [rbp-1544]
	mov r9,r8
	mov qword [rbp-1328],r9
	mov r8,qword [rbp-1328]
	imul r8,8
	mov qword [rbp-1328],r8
	mov r8,qword [rbp-1328]
	mov r9,r8
	mov qword [rbp-1136],r9
	mov r8,qword [rbp-976]
	mov r9,qword [rbp-1136]
	add r9,r8
	mov qword [rbp-1136],r9
	mov r8,qword [rbp-1136]
	mov qword [r8+8],0
	mov r8,qword [rbp-472]
	mov r9,r8
	mov qword [rbp-136],r9
	mov r8,qword [rbp-136]
	imul r8,8
	mov qword [rbp-136],r8
	mov r8,qword [rbp-136]
	mov r9,r8
	mov qword [rbp-1720],r9
	mov r8,qword [rbp-1840]
	mov r9,qword [rbp-1720]
	add r9,r8
	mov qword [rbp-1720],r9
	mov r8,qword [rbp-1720]
	mov qword [r8+8],0
	jmp ___search..if_after_2
___search..if_after_2:
	jmp ___search..for_step
___search..for_step:
	mov r8,qword [rbp-472]
	mov r9,r8
	mov qword [rbp-2120],r9
	mov r8,qword [rbp-472]
	add r8,1
	mov qword [rbp-472],r8
	jmp ___search..for_cond
___search..for_after:
	jmp ___search..if_after_4
___search..if_true_3:
	mov r8,qword [rbp-1760]
	mov r9,r8
	mov qword [rbp-1560],r9
	mov r8,qword [rbp-1560]
	imul r8,8
	mov qword [rbp-1560],r8
	mov r8,qword [rbp-1560]
	mov r9,r8
	mov qword [rbp-584],r9
	mov r8,qword [rbp-840]
	mov r9,qword [rbp-584]
	add r9,r8
	mov qword [rbp-584],r9
	mov r8,qword [rbp-584]
	mov r8,qword [r8+8]
	mov qword [rbp-584],r8
	mov r8,qword [rbp-584]
	mov r9,r8
	mov qword [rbp-728],r9
	mov r8,qword [rbp-728]
	add r8,0
	mov qword [rbp-728],r8
	mov r8,qword [rbp-728]
	mov r9,r8
	mov qword [rbp-1264],r9
	mov r8,qword [rbp-1264]
	mov r8,qword [r8+8]
	mov qword [rbp-1264],r8
	mov r8,15
	mov qword [rbp-40],r8
	mov r8,qword [rbp-1264]
	mov r9,qword [rbp-40]
	sub r9,r8
	mov qword [rbp-40],r9
	mov r8,qword [rbp-40]
	mov r9,r8
	mov qword [rbp-160],r9
	mov r8,qword [rbp-1760]
	mov r9,r8
	mov qword [rbp-2152],r9
	mov r8,qword [rbp-2152]
	imul r8,8
	mov qword [rbp-2152],r8
	mov r8,qword [rbp-2152]
	mov r9,r8
	mov qword [rbp-904],r9
	mov r8,qword [rbp-840]
	mov r9,qword [rbp-904]
	add r9,r8
	mov qword [rbp-904],r9
	mov r8,qword [rbp-904]
	mov r8,qword [r8+8]
	mov qword [rbp-904],r8
	mov r8,qword [rbp-904]
	mov r9,r8
	mov qword [rbp-1864],r9
	mov r8,qword [rbp-1864]
	add r8,8
	mov qword [rbp-1864],r8
	mov r8,qword [rbp-1864]
	mov r9,r8
	mov qword [rbp-1472],r9
	mov r8,qword [rbp-1472]
	mov r8,qword [r8+8]
	mov qword [rbp-1472],r8
	mov r8,qword [rbp-160]
	mov r9,r8
	mov qword [rbp-896],r9
	mov r8,qword [rbp-1472]
	mov r9,qword [rbp-896]
	sub r9,r8
	mov qword [rbp-896],r9
	mov r8,qword [rbp-896]
	mov r9,r8
	mov qword [rbp-816],r9
	mov r8,qword [rbp-1760]
	mov r9,r8
	mov qword [rbp-888],r9
	mov r8,qword [rbp-888]
	imul r8,8
	mov qword [rbp-888],r8
	mov r8,qword [rbp-888]
	mov r9,r8
	mov qword [rbp-1632],r9
	mov r8,qword [rbp-840]
	mov r9,qword [rbp-1632]
	add r9,r8
	mov qword [rbp-1632],r9
	mov r8,qword [rbp-1632]
	mov r8,qword [r8+8]
	mov qword [rbp-1632],r8
	mov r8,qword [rbp-1544]
	mov r9,r8
	mov qword [rbp-2200],r9
	mov r8,qword [rbp-2200]
	imul r8,8
	mov qword [rbp-2200],r8
	mov r8,qword [rbp-2200]
	mov r9,r8
	mov qword [rbp-2344],r9
	mov r8,qword [rbp-1632]
	mov r9,qword [rbp-2344]
	add r9,r8
	mov qword [rbp-2344],r9
	mov r8,qword [rbp-2344]
	mov r9,qword [rbp-816]
	mov qword [r8+8],r9
	mov r8,qword [rbp-1760]
	mov r9,r8
	mov qword [rbp-1064],r9
	mov r8,qword [rbp-1064]
	imul r8,8
	mov qword [rbp-1064],r8
	mov r8,qword [rbp-1064]
	mov r9,r8
	mov qword [rbp-952],r9
	mov r8,qword [rbp-840]
	mov r9,qword [rbp-952]
	add r9,r8
	mov qword [rbp-952],r9
	mov r8,qword [rbp-952]
	mov r8,qword [r8+8]
	mov qword [rbp-952],r8
	mov r8,qword [rbp-1544]
	mov r9,r8
	mov qword [rbp-1072],r9
	mov r8,qword [rbp-1072]
	imul r8,8
	mov qword [rbp-1072],r8
	mov r8,qword [rbp-1072]
	mov r9,r8
	mov qword [rbp-1776],r9
	mov r8,qword [rbp-952]
	mov r9,qword [rbp-1776]
	add r9,r8
	mov qword [rbp-1776],r9
	mov r8,qword [rbp-1776]
	mov r8,qword [r8+8]
	mov qword [rbp-1776],r8
	mov r8,qword [rbp-1776]
	cmp r8,0
	mov r9,0
	setg r9b
	mov qword [rbp-240],r9
	mov r8,qword [rbp-240]
	cmp r8b,1
	jz ___search..lhs_true_5
	jnz ___search..lhs_false_5
___search..lhs_false_5:
	mov r8,0
	mov qword [rbp-1768],r8
	jmp ___search..lhs_merge_5
___search..lhs_true_5:
	mov r8,qword [rbp-1760]
	mov r9,r8
	mov qword [rbp-1576],r9
	mov r8,qword [rbp-1576]
	imul r8,8
	mov qword [rbp-1576],r8
	mov r8,qword [rbp-1576]
	mov r9,r8
	mov qword [rbp-2352],r9
	mov r8,qword [rbp-840]
	mov r9,qword [rbp-2352]
	add r9,r8
	mov qword [rbp-2352],r9
	mov r8,qword [rbp-2352]
	mov r8,qword [r8+8]
	mov qword [rbp-2352],r8
	mov r8,qword [rbp-1544]
	mov r9,r8
	mov qword [rbp-2024],r9
	mov r8,qword [rbp-2024]
	imul r8,8
	mov qword [rbp-2024],r8
	mov r8,qword [rbp-2024]
	mov r9,r8
	mov qword [rbp-824],r9
	mov r8,qword [rbp-2352]
	mov r9,qword [rbp-824]
	add r9,r8
	mov qword [rbp-824],r9
	mov r8,qword [rbp-824]
	mov r8,qword [r8+8]
	mov qword [rbp-824],r8
	mov r8,qword [rbp-824]
	cmp r8,10
	mov r9,0
	setl r9b
	mov qword [rbp-920],r9
	mov r8,qword [rbp-920]
	mov r9,r8
	mov qword [rbp-1768],r9
	jmp ___search..lhs_merge_5
___search..lhs_merge_5:
	mov r8,qword [rbp-1768]
	cmp r8b,1
	jz ___search..lhs_true_6
	jnz ___search..lhs_false_6
___search..lhs_false_6:
	mov r8,0
	mov qword [rbp-2288],r8
	jmp ___search..lhs_merge_6
___search..lhs_true_6:
	mov r8,qword [rbp-1760]
	mov r9,r8
	mov qword [rbp-2008],r9
	mov r8,qword [rbp-2008]
	imul r8,8
	mov qword [rbp-2008],r8
	mov r8,qword [rbp-2008]
	mov r9,r8
	mov qword [rbp-312],r9
	mov r8,qword [rbp-840]
	mov r9,qword [rbp-312]
	add r9,r8
	mov qword [rbp-312],r9
	mov r8,qword [rbp-312]
	mov r8,qword [r8+8]
	mov qword [rbp-312],r8
	mov r8,qword [rbp-1544]
	mov r9,r8
	mov qword [rbp-1272],r9
	mov r8,qword [rbp-1272]
	imul r8,8
	mov qword [rbp-1272],r8
	mov r8,qword [rbp-1272]
	mov r9,r8
	mov qword [rbp-1408],r9
	mov r8,qword [rbp-312]
	mov r9,qword [rbp-1408]
	add r9,r8
	mov qword [rbp-1408],r9
	mov r8,qword [rbp-1408]
	mov r8,qword [r8+8]
	mov qword [rbp-1408],r8
	mov r8,qword [rbp-1408]
	mov r9,r8
	mov qword [rbp-2224],r9
	mov r8,qword [rbp-2224]
	imul r8,8
	mov qword [rbp-2224],r8
	mov r8,qword [rbp-2224]
	mov r9,r8
	mov qword [rbp-1624],r9
	mov r8,qword [rbp-1840]
	mov r9,qword [rbp-1624]
	add r9,r8
	mov qword [rbp-1624],r9
	mov r8,qword [rbp-1624]
	mov r8,qword [r8+8]
	mov qword [rbp-1624],r8
	mov r8,qword [rbp-1624]
	cmp r8,0
	mov r9,0
	sete r9b
	mov qword [rbp-1800],r9
	mov r8,qword [rbp-1800]
	mov r9,r8
	mov qword [rbp-2288],r9
	jmp ___search..lhs_merge_6
___search..lhs_merge_6:
	mov r8,qword [rbp-2288]
	cmp r8b,1
	jz ___search..if_true_6
	jnz ___search..if_after_5
___search..if_true_6:
	mov r8,qword [rbp-1760]
	mov r9,r8
	mov qword [rbp-2064],r9
	mov r8,qword [rbp-2064]
	imul r8,8
	mov qword [rbp-2064],r8
	mov r8,qword [rbp-2064]
	mov r9,r8
	mov qword [rbp-72],r9
	mov r8,qword [rbp-840]
	mov r9,qword [rbp-72]
	add r9,r8
	mov qword [rbp-72],r9
	mov r8,qword [rbp-72]
	mov r8,qword [r8+8]
	mov qword [rbp-72],r8
	mov r8,qword [rbp-1544]
	mov r9,r8
	mov qword [rbp-24],r9
	mov r8,qword [rbp-24]
	imul r8,8
	mov qword [rbp-24],r8
	mov r8,qword [rbp-24]
	mov r9,r8
	mov qword [rbp-1008],r9
	mov r8,qword [rbp-72]
	mov r9,qword [rbp-1008]
	add r9,r8
	mov qword [rbp-1008],r9
	mov r8,qword [rbp-1008]
	mov r8,qword [r8+8]
	mov qword [rbp-1008],r8
	mov r8,qword [rbp-1008]
	mov r9,r8
	mov qword [rbp-1648],r9
	mov r8,qword [rbp-1648]
	imul r8,8
	mov qword [rbp-1648],r8
	mov r8,qword [rbp-1648]
	mov r9,r8
	mov qword [rbp-2280],r9
	mov r8,qword [rbp-1840]
	mov r9,qword [rbp-2280]
	add r9,r8
	mov qword [rbp-2280],r9
	mov r8,qword [rbp-2280]
	mov qword [r8+8],1
	mov r8,qword [rbp-1544]
	cmp r8,2
	mov r9,0
	sete r9b
	mov qword [rbp-1744],r9
	mov r8,qword [rbp-1744]
	cmp r8b,1
	jz ___search..if_true_7
	jnz ___search..if_false_4
___search..if_false_4:
	mov r8,qword [rbp-1544]
	mov r9,r8
	mov qword [rbp-1032],r9
	mov r8,qword [rbp-1032]
	add r8,1
	mov qword [rbp-1032],r8
	mov r8,qword [rbp-1032]
	mov r9,r8
	mov qword [rbp-96],r9
	mov r8,qword [rbp-1760]
	mov r9,r8
	mov qword [rbp-1464],r9
	mov r8,qword [rbp-1464]
	imul r8,8
	mov qword [rbp-1464],r8
	mov r8,qword [rbp-1464]
	mov r9,r8
	mov qword [rbp-192],r9
	mov r8,qword [rbp-840]
	mov r9,qword [rbp-192]
	add r9,r8
	mov qword [rbp-192],r9
	mov r8,qword [rbp-192]
	mov r8,qword [r8+8]
	mov qword [rbp-192],r8
	mov r8,qword [rbp-1544]
	mov r9,r8
	mov qword [rbp-504],r9
	mov r8,qword [rbp-504]
	imul r8,8
	mov qword [rbp-504],r8
	mov r8,qword [rbp-504]
	mov r9,r8
	mov qword [rbp-64],r9
	mov r8,qword [rbp-192]
	mov r9,qword [rbp-64]
	add r9,r8
	mov qword [rbp-64],r9
	mov r8,qword [rbp-64]
	mov r8,qword [r8+8]
	mov qword [rbp-64],r8
	mov r8,qword [rbp-1112]
	mov r9,r8
	mov qword [rbp-1872],r9
	mov r8,qword [rbp-64]
	mov r9,qword [rbp-1872]
	add r9,r8
	mov qword [rbp-1872],r9
	mov r8,qword [rbp-1872]
	mov r9,r8
	mov qword [rbp-2104],r9
	mov qword [rbp-2400],r8
	mov qword [rbp-2408],r10
	mov qword [rbp-2416],r9
	mov qword [rbp-2424],rdi
	mov qword [rbp-2432],rsi
	mov qword [rbp-2440],rdx
	mov rdx,qword [rbp-2104]
	mov rsi,qword [rbp-96]
	mov rdi,qword [rbp-1760]
	call ___search
	mov rdx,qword [rbp-2440]
	mov rsi,qword [rbp-2432]
	mov rdi,qword [rbp-2424]
	mov r9,qword [rbp-2416]
	mov r10,qword [rbp-2408]
	mov r8,qword [rbp-2400]
	mov r8,rax
	mov qword [rbp-744],r8
	jmp ___search..if_after_6
___search..if_true_7:
	mov r8,qword [rbp-1760]
	mov r9,r8
	mov qword [rbp-48],r9
	mov r8,qword [rbp-48]
	add r8,1
	mov qword [rbp-48],r8
	mov r8,qword [rbp-48]
	mov r9,r8
	mov qword [rbp-680],r9
	mov r8,qword [rbp-1760]
	mov r9,r8
	mov qword [rbp-320],r9
	mov r8,qword [rbp-320]
	imul r8,8
	mov qword [rbp-320],r8
	mov r8,qword [rbp-320]
	mov r9,r8
	mov qword [rbp-1552],r9
	mov r8,qword [rbp-840]
	mov r9,qword [rbp-1552]
	add r9,r8
	mov qword [rbp-1552],r9
	mov r8,qword [rbp-1552]
	mov r8,qword [r8+8]
	mov qword [rbp-1552],r8
	mov r8,qword [rbp-1544]
	mov r9,r8
	mov qword [rbp-2088],r9
	mov r8,qword [rbp-2088]
	imul r8,8
	mov qword [rbp-2088],r8
	mov r8,qword [rbp-2088]
	mov r9,r8
	mov qword [rbp-712],r9
	mov r8,qword [rbp-1552]
	mov r9,qword [rbp-712]
	add r9,r8
	mov qword [rbp-712],r9
	mov r8,qword [rbp-712]
	mov r8,qword [r8+8]
	mov qword [rbp-712],r8
	mov r8,qword [rbp-1112]
	mov r9,r8
	mov qword [rbp-936],r9
	mov r8,qword [rbp-712]
	mov r9,qword [rbp-936]
	add r9,r8
	mov qword [rbp-936],r9
	mov r8,qword [rbp-936]
	mov r9,r8
	mov qword [rbp-2272],r9
	mov qword [rbp-2400],r8
	mov qword [rbp-2408],r10
	mov qword [rbp-2416],r9
	mov qword [rbp-2424],rdi
	mov qword [rbp-2432],rsi
	mov qword [rbp-2440],rdx
	mov rdx,qword [rbp-2272]
	mov rsi,0
	mov rdi,qword [rbp-680]
	call ___search
	mov rdx,qword [rbp-2440]
	mov rsi,qword [rbp-2432]
	mov rdi,qword [rbp-2424]
	mov r9,qword [rbp-2416]
	mov r10,qword [rbp-2408]
	mov r8,qword [rbp-2400]
	mov r8,rax
	mov qword [rbp-2144],r8
	jmp ___search..if_after_6
___search..if_after_6:
	mov r8,qword [rbp-1760]
	mov r9,r8
	mov qword [rbp-104],r9
	mov r8,qword [rbp-104]
	imul r8,8
	mov qword [rbp-104],r8
	mov r8,qword [rbp-104]
	mov r9,r8
	mov qword [rbp-1216],r9
	mov r8,qword [rbp-840]
	mov r9,qword [rbp-1216]
	add r9,r8
	mov qword [rbp-1216],r9
	mov r8,qword [rbp-1216]
	mov r8,qword [r8+8]
	mov qword [rbp-1216],r8
	mov r8,qword [rbp-1544]
	mov r9,r8
	mov qword [rbp-440],r9
	mov r8,qword [rbp-440]
	imul r8,8
	mov qword [rbp-440],r8
	mov r8,qword [rbp-440]
	mov r9,r8
	mov qword [rbp-1480],r9
	mov r8,qword [rbp-1216]
	mov r9,qword [rbp-1480]
	add r9,r8
	mov qword [rbp-1480],r9
	mov r8,qword [rbp-1480]
	mov r8,qword [r8+8]
	mov qword [rbp-1480],r8
	mov r8,qword [rbp-1480]
	mov r9,r8
	mov qword [rbp-1616],r9
	mov r8,qword [rbp-1616]
	imul r8,8
	mov qword [rbp-1616],r8
	mov r8,qword [rbp-1616]
	mov r9,r8
	mov qword [rbp-2392],r9
	mov r8,qword [rbp-1840]
	mov r9,qword [rbp-2392]
	add r9,r8
	mov qword [rbp-2392],r9
	mov r8,qword [rbp-2392]
	mov qword [r8+8],0
	jmp ___search..if_after_5
___search..if_after_5:
	jmp ___search..if_after_4
___search..if_after_4:
	jmp ___search..if_after_7
___search..if_true_2:
	mov r8,45
	mov qword [rbp-1352],r8
	mov r8,qword [rbp-1112]
	mov r9,qword [rbp-1352]
	sub r9,r8
	mov qword [rbp-1352],r9
	mov r8,qword [rbp-1352]
	mov r9,r8
	mov qword [rbp-1752],r9
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-2376],r9
	mov r8,qword [rbp-2376]
	add r8,16
	mov qword [rbp-2376],r8
	mov r8,qword [rbp-2376]
	mov r9,r8
	mov qword [rbp-872],r9
	mov r8,qword [rbp-872]
	mov r8,qword [r8+8]
	mov qword [rbp-872],r8
	mov r8,qword [rbp-872]
	mov r9,r8
	mov qword [rbp-448],r9
	mov r8,qword [rbp-448]
	add r8,16
	mov qword [rbp-448],r8
	mov r8,qword [rbp-448]
	mov r9,r8
	mov qword [rbp-2176],r9
	mov r8,qword [rbp-2176]
	mov r9,qword [rbp-1752]
	mov qword [r8+8],r9
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-496],r9
	mov r8,qword [rbp-496]
	add r8,0
	mov qword [rbp-496],r8
	mov r8,qword [rbp-496]
	mov r9,r8
	mov qword [rbp-1568],r9
	mov r8,qword [rbp-1568]
	mov r8,qword [r8+8]
	mov qword [rbp-1568],r8
	mov r8,qword [rbp-1568]
	mov r9,r8
	mov qword [rbp-168],r9
	mov r8,qword [rbp-168]
	add r8,0
	mov qword [rbp-168],r8
	mov r8,qword [rbp-168]
	mov r9,r8
	mov qword [rbp-248],r9
	mov r8,qword [rbp-248]
	mov r8,qword [r8+8]
	mov qword [rbp-248],r8
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-368],r9
	mov r8,qword [rbp-368]
	add r8,0
	mov qword [rbp-368],r8
	mov r8,qword [rbp-368]
	mov r9,r8
	mov qword [rbp-296],r9
	mov r8,qword [rbp-296]
	mov r8,qword [r8+8]
	mov qword [rbp-296],r8
	mov r8,qword [rbp-296]
	mov r9,r8
	mov qword [rbp-1520],r9
	mov r8,qword [rbp-1520]
	add r8,8
	mov qword [rbp-1520],r8
	mov r8,qword [rbp-1520]
	mov r9,r8
	mov qword [rbp-640],r9
	mov r8,qword [rbp-640]
	mov r8,qword [r8+8]
	mov qword [rbp-640],r8
	mov r8,qword [rbp-248]
	mov r9,r8
	mov qword [rbp-720],r9
	mov r8,qword [rbp-640]
	mov r9,qword [rbp-720]
	add r9,r8
	mov qword [rbp-720],r9
	mov r8,qword [rbp-720]
	mov r9,r8
	mov qword [rbp-352],r9
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-232],r9
	mov r8,qword [rbp-232]
	add r8,0
	mov qword [rbp-232],r8
	mov r8,qword [rbp-232]
	mov r9,r8
	mov qword [rbp-832],r9
	mov r8,qword [rbp-832]
	mov r8,qword [r8+8]
	mov qword [rbp-832],r8
	mov r8,qword [rbp-832]
	mov r9,r8
	mov qword [rbp-512],r9
	mov r8,qword [rbp-512]
	add r8,16
	mov qword [rbp-512],r8
	mov r8,qword [rbp-512]
	mov r9,r8
	mov qword [rbp-176],r9
	mov r8,qword [rbp-176]
	mov r8,qword [r8+8]
	mov qword [rbp-176],r8
	mov r8,qword [rbp-352]
	mov r9,r8
	mov qword [rbp-256],r9
	mov r8,qword [rbp-176]
	mov r9,qword [rbp-256]
	add r9,r8
	mov qword [rbp-256],r9
	mov r8,qword [rbp-256]
	mov r9,r8
	mov qword [rbp-2208],r9
	mov r8,qword [rbp-2208]
	mov r9,r8
	mov qword [rbp-856],r9
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-600],r9
	mov r8,qword [rbp-600]
	add r8,8
	mov qword [rbp-600],r8
	mov r8,qword [rbp-600]
	mov r9,r8
	mov qword [rbp-632],r9
	mov r8,qword [rbp-632]
	mov r8,qword [r8+8]
	mov qword [rbp-632],r8
	mov r8,qword [rbp-632]
	mov r9,r8
	mov qword [rbp-1584],r9
	mov r8,qword [rbp-1584]
	add r8,0
	mov qword [rbp-1584],r8
	mov r8,qword [rbp-1584]
	mov r9,r8
	mov qword [rbp-528],r9
	mov r8,qword [rbp-528]
	mov r8,qword [r8+8]
	mov qword [rbp-528],r8
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-1256],r9
	mov r8,qword [rbp-1256]
	add r8,8
	mov qword [rbp-1256],r8
	mov r8,qword [rbp-1256]
	mov r9,r8
	mov qword [rbp-736],r9
	mov r8,qword [rbp-736]
	mov r8,qword [r8+8]
	mov qword [rbp-736],r8
	mov r8,qword [rbp-736]
	mov r9,r8
	mov qword [rbp-800],r9
	mov r8,qword [rbp-800]
	add r8,8
	mov qword [rbp-800],r8
	mov r8,qword [rbp-800]
	mov r9,r8
	mov qword [rbp-8],r9
	mov r8,qword [rbp-8]
	mov r8,qword [r8+8]
	mov qword [rbp-8],r8
	mov r8,qword [rbp-528]
	mov r9,r8
	mov qword [rbp-1280],r9
	mov r8,qword [rbp-8]
	mov r9,qword [rbp-1280]
	add r9,r8
	mov qword [rbp-1280],r9
	mov r8,qword [rbp-1280]
	mov r9,r8
	mov qword [rbp-2184],r9
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-1224],r9
	mov r8,qword [rbp-1224]
	add r8,8
	mov qword [rbp-1224],r8
	mov r8,qword [rbp-1224]
	mov r9,r8
	mov qword [rbp-336],r9
	mov r8,qword [rbp-336]
	mov r8,qword [r8+8]
	mov qword [rbp-336],r8
	mov r8,qword [rbp-336]
	mov r9,r8
	mov qword [rbp-384],r9
	mov r8,qword [rbp-384]
	add r8,16
	mov qword [rbp-384],r8
	mov r8,qword [rbp-384]
	mov r9,r8
	mov qword [rbp-456],r9
	mov r8,qword [rbp-456]
	mov r8,qword [r8+8]
	mov qword [rbp-456],r8
	mov r8,qword [rbp-2184]
	mov r9,r8
	mov qword [rbp-88],r9
	mov r8,qword [rbp-456]
	mov r9,qword [rbp-88]
	add r9,r8
	mov qword [rbp-88],r9
	mov r8,qword [rbp-88]
	mov r9,r8
	mov qword [rbp-1144],r9
	mov r8,qword [rbp-1144]
	mov r9,qword [rbp-856]
	cmp r8,r9
	mov r10,0
	sete r10b
	mov qword [rbp-520],r10
	mov r8,qword [rbp-520]
	cmp r8b,1
	jz ___search..lhs_true_7
	jnz ___search..lhs_false_7
___search..lhs_false_7:
	mov r8,0
	mov qword [rbp-992],r8
	jmp ___search..lhs_merge_7
___search..lhs_true_7:
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-1168],r9
	mov r8,qword [rbp-1168]
	add r8,16
	mov qword [rbp-1168],r8
	mov r8,qword [rbp-1168]
	mov r9,r8
	mov qword [rbp-1728],r9
	mov r8,qword [rbp-1728]
	mov r8,qword [r8+8]
	mov qword [rbp-1728],r8
	mov r8,qword [rbp-1728]
	mov r9,r8
	mov qword [rbp-944],r9
	mov r8,qword [rbp-944]
	add r8,0
	mov qword [rbp-944],r8
	mov r8,qword [rbp-944]
	mov r9,r8
	mov qword [rbp-536],r9
	mov r8,qword [rbp-536]
	mov r8,qword [r8+8]
	mov qword [rbp-536],r8
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-1824],r9
	mov r8,qword [rbp-1824]
	add r8,16
	mov qword [rbp-1824],r8
	mov r8,qword [rbp-1824]
	mov r9,r8
	mov qword [rbp-864],r9
	mov r8,qword [rbp-864]
	mov r8,qword [r8+8]
	mov qword [rbp-864],r8
	mov r8,qword [rbp-864]
	mov r9,r8
	mov qword [rbp-760],r9
	mov r8,qword [rbp-760]
	add r8,8
	mov qword [rbp-760],r8
	mov r8,qword [rbp-760]
	mov r9,r8
	mov qword [rbp-392],r9
	mov r8,qword [rbp-392]
	mov r8,qword [r8+8]
	mov qword [rbp-392],r8
	mov r8,qword [rbp-536]
	mov r9,r8
	mov qword [rbp-2160],r9
	mov r8,qword [rbp-392]
	mov r9,qword [rbp-2160]
	add r9,r8
	mov qword [rbp-2160],r9
	mov r8,qword [rbp-2160]
	mov r9,r8
	mov qword [rbp-1536],r9
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-1960],r9
	mov r8,qword [rbp-1960]
	add r8,16
	mov qword [rbp-1960],r8
	mov r8,qword [rbp-1960]
	mov r9,r8
	mov qword [rbp-304],r9
	mov r8,qword [rbp-304]
	mov r8,qword [r8+8]
	mov qword [rbp-304],r8
	mov r8,qword [rbp-304]
	mov r9,r8
	mov qword [rbp-2216],r9
	mov r8,qword [rbp-2216]
	add r8,16
	mov qword [rbp-2216],r8
	mov r8,qword [rbp-2216]
	mov r9,r8
	mov qword [rbp-2384],r9
	mov r8,qword [rbp-2384]
	mov r8,qword [r8+8]
	mov qword [rbp-2384],r8
	mov r8,qword [rbp-1536]
	mov r9,r8
	mov qword [rbp-408],r9
	mov r8,qword [rbp-2384]
	mov r9,qword [rbp-408]
	add r9,r8
	mov qword [rbp-408],r9
	mov r8,qword [rbp-408]
	mov r9,r8
	mov qword [rbp-80],r9
	mov r8,qword [rbp-80]
	mov r9,qword [rbp-856]
	cmp r8,r9
	mov r10,0
	sete r10b
	mov qword [rbp-1376],r10
	mov r8,qword [rbp-1376]
	mov r9,r8
	mov qword [rbp-992],r9
	jmp ___search..lhs_merge_7
___search..lhs_merge_7:
	mov r8,qword [rbp-992]
	cmp r8b,1
	jz ___search..lhs_true_8
	jnz ___search..lhs_false_8
___search..lhs_false_8:
	mov r8,0
	mov qword [rbp-1816],r8
	jmp ___search..lhs_merge_8
___search..lhs_true_8:
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-2328],r9
	mov r8,qword [rbp-2328]
	add r8,0
	mov qword [rbp-2328],r8
	mov r8,qword [rbp-2328]
	mov r9,r8
	mov qword [rbp-1984],r9
	mov r8,qword [rbp-1984]
	mov r8,qword [r8+8]
	mov qword [rbp-1984],r8
	mov r8,qword [rbp-1984]
	mov r9,r8
	mov qword [rbp-1888],r9
	mov r8,qword [rbp-1888]
	add r8,0
	mov qword [rbp-1888],r8
	mov r8,qword [rbp-1888]
	mov r9,r8
	mov qword [rbp-112],r9
	mov r8,qword [rbp-112]
	mov r8,qword [r8+8]
	mov qword [rbp-112],r8
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-2040],r9
	mov r8,qword [rbp-2040]
	add r8,8
	mov qword [rbp-2040],r8
	mov r8,qword [rbp-2040]
	mov r9,r8
	mov qword [rbp-1896],r9
	mov r8,qword [rbp-1896]
	mov r8,qword [r8+8]
	mov qword [rbp-1896],r8
	mov r8,qword [rbp-1896]
	mov r9,r8
	mov qword [rbp-1712],r9
	mov r8,qword [rbp-1712]
	add r8,0
	mov qword [rbp-1712],r8
	mov r8,qword [rbp-1712]
	mov r9,r8
	mov qword [rbp-2048],r9
	mov r8,qword [rbp-2048]
	mov r8,qword [r8+8]
	mov qword [rbp-2048],r8
	mov r8,qword [rbp-112]
	mov r9,r8
	mov qword [rbp-480],r9
	mov r8,qword [rbp-2048]
	mov r9,qword [rbp-480]
	add r9,r8
	mov qword [rbp-480],r9
	mov r8,qword [rbp-480]
	mov r9,r8
	mov qword [rbp-1992],r9
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-776],r9
	mov r8,qword [rbp-776]
	add r8,16
	mov qword [rbp-776],r8
	mov r8,qword [rbp-776]
	mov r9,r8
	mov qword [rbp-2240],r9
	mov r8,qword [rbp-2240]
	mov r8,qword [r8+8]
	mov qword [rbp-2240],r8
	mov r8,qword [rbp-2240]
	mov r9,r8
	mov qword [rbp-768],r9
	mov r8,qword [rbp-768]
	add r8,0
	mov qword [rbp-768],r8
	mov r8,qword [rbp-768]
	mov r9,r8
	mov qword [rbp-2368],r9
	mov r8,qword [rbp-2368]
	mov r8,qword [r8+8]
	mov qword [rbp-2368],r8
	mov r8,qword [rbp-1992]
	mov r9,r8
	mov qword [rbp-1080],r9
	mov r8,qword [rbp-2368]
	mov r9,qword [rbp-1080]
	add r9,r8
	mov qword [rbp-1080],r9
	mov r8,qword [rbp-1080]
	mov r9,r8
	mov qword [rbp-704],r9
	mov r8,qword [rbp-704]
	mov r9,qword [rbp-856]
	cmp r8,r9
	mov r10,0
	sete r10b
	mov qword [rbp-2296],r10
	mov r8,qword [rbp-2296]
	mov r9,r8
	mov qword [rbp-1816],r9
	jmp ___search..lhs_merge_8
___search..lhs_merge_8:
	mov r8,qword [rbp-1816]
	cmp r8b,1
	jz ___search..lhs_true_9
	jnz ___search..lhs_false_9
___search..lhs_true_9:
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-2032],r9
	mov r8,qword [rbp-2032]
	add r8,0
	mov qword [rbp-2032],r8
	mov r8,qword [rbp-2032]
	mov r9,r8
	mov qword [rbp-1304],r9
	mov r8,qword [rbp-1304]
	mov r8,qword [r8+8]
	mov qword [rbp-1304],r8
	mov r8,qword [rbp-1304]
	mov r9,r8
	mov qword [rbp-1512],r9
	mov r8,qword [rbp-1512]
	add r8,8
	mov qword [rbp-1512],r8
	mov r8,qword [rbp-1512]
	mov r9,r8
	mov qword [rbp-1488],r9
	mov r8,qword [rbp-1488]
	mov r8,qword [r8+8]
	mov qword [rbp-1488],r8
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-1040],r9
	mov r8,qword [rbp-1040]
	add r8,8
	mov qword [rbp-1040],r8
	mov r8,qword [rbp-1040]
	mov r9,r8
	mov qword [rbp-1312],r9
	mov r8,qword [rbp-1312]
	mov r8,qword [r8+8]
	mov qword [rbp-1312],r8
	mov r8,qword [rbp-1312]
	mov r9,r8
	mov qword [rbp-1640],r9
	mov r8,qword [rbp-1640]
	add r8,8
	mov qword [rbp-1640],r8
	mov r8,qword [rbp-1640]
	mov r9,r8
	mov qword [rbp-1808],r9
	mov r8,qword [rbp-1808]
	mov r8,qword [r8+8]
	mov qword [rbp-1808],r8
	mov r8,qword [rbp-1488]
	mov r9,r8
	mov qword [rbp-1880],r9
	mov r8,qword [rbp-1808]
	mov r9,qword [rbp-1880]
	add r9,r8
	mov qword [rbp-1880],r9
	mov r8,qword [rbp-1880]
	mov r9,r8
	mov qword [rbp-1704],r9
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-120],r9
	mov r8,qword [rbp-120]
	add r8,16
	mov qword [rbp-120],r8
	mov r8,qword [rbp-120]
	mov r9,r8
	mov qword [rbp-1232],r9
	mov r8,qword [rbp-1232]
	mov r8,qword [r8+8]
	mov qword [rbp-1232],r8
	mov r8,qword [rbp-1232]
	mov r9,r8
	mov qword [rbp-1160],r9
	mov r8,qword [rbp-1160]
	add r8,8
	mov qword [rbp-1160],r8
	mov r8,qword [rbp-1160]
	mov r9,r8
	mov qword [rbp-208],r9
	mov r8,qword [rbp-208]
	mov r8,qword [r8+8]
	mov qword [rbp-208],r8
	mov r8,qword [rbp-1704]
	mov r9,r8
	mov qword [rbp-2168],r9
	mov r8,qword [rbp-208]
	mov r9,qword [rbp-2168]
	add r9,r8
	mov qword [rbp-2168],r9
	mov r8,qword [rbp-2168]
	mov r9,r8
	mov qword [rbp-424],r9
	mov r8,qword [rbp-424]
	mov r9,qword [rbp-856]
	cmp r8,r9
	mov r10,0
	sete r10b
	mov qword [rbp-1016],r10
	mov r8,qword [rbp-1016]
	mov r9,r8
	mov qword [rbp-264],r9
	jmp ___search..lhs_merge_9
___search..lhs_false_9:
	mov r8,0
	mov qword [rbp-264],r8
	jmp ___search..lhs_merge_9
___search..lhs_merge_9:
	mov r8,qword [rbp-264]
	cmp r8b,1
	jz ___search..lhs_true_10
	jnz ___search..lhs_false_10
___search..lhs_false_10:
	mov r8,0
	mov qword [rbp-1936],r8
	jmp ___search..lhs_merge_10
___search..lhs_true_10:
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-664],r9
	mov r8,qword [rbp-664]
	add r8,0
	mov qword [rbp-664],r8
	mov r8,qword [rbp-664]
	mov r9,r8
	mov qword [rbp-1784],r9
	mov r8,qword [rbp-1784]
	mov r8,qword [r8+8]
	mov qword [rbp-1784],r8
	mov r8,qword [rbp-1784]
	mov r9,r8
	mov qword [rbp-1432],r9
	mov r8,qword [rbp-1432]
	add r8,16
	mov qword [rbp-1432],r8
	mov r8,qword [rbp-1432]
	mov r9,r8
	mov qword [rbp-1208],r9
	mov r8,qword [rbp-1208]
	mov r8,qword [r8+8]
	mov qword [rbp-1208],r8
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-1320],r9
	mov r8,qword [rbp-1320]
	add r8,8
	mov qword [rbp-1320],r8
	mov r8,qword [rbp-1320]
	mov r9,r8
	mov qword [rbp-1448],r9
	mov r8,qword [rbp-1448]
	mov r8,qword [r8+8]
	mov qword [rbp-1448],r8
	mov r8,qword [rbp-1448]
	mov r9,r8
	mov qword [rbp-360],r9
	mov r8,qword [rbp-360]
	add r8,16
	mov qword [rbp-360],r8
	mov r8,qword [rbp-360]
	mov r9,r8
	mov qword [rbp-1344],r9
	mov r8,qword [rbp-1344]
	mov r8,qword [r8+8]
	mov qword [rbp-1344],r8
	mov r8,qword [rbp-1208]
	mov r9,r8
	mov qword [rbp-128],r9
	mov r8,qword [rbp-1344]
	mov r9,qword [rbp-128]
	add r9,r8
	mov qword [rbp-128],r9
	mov r8,qword [rbp-128]
	mov r9,r8
	mov qword [rbp-1384],r9
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-648],r9
	mov r8,qword [rbp-648]
	add r8,16
	mov qword [rbp-648],r8
	mov r8,qword [rbp-648]
	mov r9,r8
	mov qword [rbp-216],r9
	mov r8,qword [rbp-216]
	mov r8,qword [r8+8]
	mov qword [rbp-216],r8
	mov r8,qword [rbp-216]
	mov r9,r8
	mov qword [rbp-752],r9
	mov r8,qword [rbp-752]
	add r8,16
	mov qword [rbp-752],r8
	mov r8,qword [rbp-752]
	mov r9,r8
	mov qword [rbp-656],r9
	mov r8,qword [rbp-656]
	mov r8,qword [r8+8]
	mov qword [rbp-656],r8
	mov r8,qword [rbp-1384]
	mov r9,r8
	mov qword [rbp-1088],r9
	mov r8,qword [rbp-656]
	mov r9,qword [rbp-1088]
	add r9,r8
	mov qword [rbp-1088],r9
	mov r8,qword [rbp-1088]
	mov r9,r8
	mov qword [rbp-1920],r9
	mov r8,qword [rbp-1920]
	mov r9,qword [rbp-856]
	cmp r8,r9
	mov r10,0
	sete r10b
	mov qword [rbp-1664],r10
	mov r8,qword [rbp-1664]
	mov r9,r8
	mov qword [rbp-1936],r9
	jmp ___search..lhs_merge_10
___search..lhs_merge_10:
	mov r8,qword [rbp-1936]
	cmp r8b,1
	jz ___search..lhs_true_11
	jnz ___search..lhs_false_11
___search..lhs_true_11:
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-1424],r9
	mov r8,qword [rbp-1424]
	add r8,0
	mov qword [rbp-1424],r8
	mov r8,qword [rbp-1424]
	mov r9,r8
	mov qword [rbp-1240],r9
	mov r8,qword [rbp-1240]
	mov r8,qword [r8+8]
	mov qword [rbp-1240],r8
	mov r8,qword [rbp-1240]
	mov r9,r8
	mov qword [rbp-1440],r9
	mov r8,qword [rbp-1440]
	add r8,0
	mov qword [rbp-1440],r8
	mov r8,qword [rbp-1440]
	mov r9,r8
	mov qword [rbp-616],r9
	mov r8,qword [rbp-616]
	mov r8,qword [r8+8]
	mov qword [rbp-616],r8
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-464],r9
	mov r8,qword [rbp-464]
	add r8,8
	mov qword [rbp-464],r8
	mov r8,qword [rbp-464]
	mov r9,r8
	mov qword [rbp-880],r9
	mov r8,qword [rbp-880]
	mov r8,qword [r8+8]
	mov qword [rbp-880],r8
	mov r8,qword [rbp-880]
	mov r9,r8
	mov qword [rbp-2056],r9
	mov r8,qword [rbp-2056]
	add r8,8
	mov qword [rbp-2056],r8
	mov r8,qword [rbp-2056]
	mov r9,r8
	mov qword [rbp-2096],r9
	mov r8,qword [rbp-2096]
	mov r8,qword [r8+8]
	mov qword [rbp-2096],r8
	mov r8,qword [rbp-616]
	mov r9,r8
	mov qword [rbp-1688],r9
	mov r8,qword [rbp-2096]
	mov r9,qword [rbp-1688]
	add r9,r8
	mov qword [rbp-1688],r9
	mov r8,qword [rbp-1688]
	mov r9,r8
	mov qword [rbp-2336],r9
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-328],r9
	mov r8,qword [rbp-328]
	add r8,16
	mov qword [rbp-328],r8
	mov r8,qword [rbp-328]
	mov r9,r8
	mov qword [rbp-1456],r9
	mov r8,qword [rbp-1456]
	mov r8,qword [r8+8]
	mov qword [rbp-1456],r8
	mov r8,qword [rbp-1456]
	mov r9,r8
	mov qword [rbp-784],r9
	mov r8,qword [rbp-784]
	add r8,16
	mov qword [rbp-784],r8
	mov r8,qword [rbp-784]
	mov r9,r8
	mov qword [rbp-1944],r9
	mov r8,qword [rbp-1944]
	mov r8,qword [r8+8]
	mov qword [rbp-1944],r8
	mov r8,qword [rbp-2336]
	mov r9,r8
	mov qword [rbp-968],r9
	mov r8,qword [rbp-1944]
	mov r9,qword [rbp-968]
	add r9,r8
	mov qword [rbp-968],r9
	mov r8,qword [rbp-968]
	mov r9,r8
	mov qword [rbp-912],r9
	mov r8,qword [rbp-912]
	mov r9,qword [rbp-856]
	cmp r8,r9
	mov r10,0
	sete r10b
	mov qword [rbp-544],r10
	mov r8,qword [rbp-544]
	mov r9,r8
	mov qword [rbp-1496],r9
	jmp ___search..lhs_merge_11
___search..lhs_false_11:
	mov r8,0
	mov qword [rbp-1496],r8
	jmp ___search..lhs_merge_11
___search..lhs_merge_11:
	mov r8,qword [rbp-1496]
	cmp r8b,1
	jz ___search..lhs_true_12
	jnz ___search..lhs_false_12
___search..lhs_false_12:
	mov r8,0
	mov qword [rbp-928],r8
	jmp ___search..lhs_merge_12
___search..lhs_true_12:
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-56],r9
	mov r8,qword [rbp-56]
	add r8,16
	mov qword [rbp-56],r8
	mov r8,qword [rbp-56]
	mov r9,r8
	mov qword [rbp-552],r9
	mov r8,qword [rbp-552]
	mov r8,qword [r8+8]
	mov qword [rbp-552],r8
	mov r8,qword [rbp-552]
	mov r9,r8
	mov qword [rbp-1096],r9
	mov r8,qword [rbp-1096]
	add r8,0
	mov qword [rbp-1096],r8
	mov r8,qword [rbp-1096]
	mov r9,r8
	mov qword [rbp-1528],r9
	mov r8,qword [rbp-1528]
	mov r8,qword [r8+8]
	mov qword [rbp-1528],r8
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-1656],r9
	mov r8,qword [rbp-1656]
	add r8,8
	mov qword [rbp-1656],r8
	mov r8,qword [rbp-1656]
	mov r9,r8
	mov qword [rbp-688],r9
	mov r8,qword [rbp-688]
	mov r8,qword [r8+8]
	mov qword [rbp-688],r8
	mov r8,qword [rbp-688]
	mov r9,r8
	mov qword [rbp-1152],r9
	mov r8,qword [rbp-1152]
	add r8,8
	mov qword [rbp-1152],r8
	mov r8,qword [rbp-1152]
	mov r9,r8
	mov qword [rbp-2304],r9
	mov r8,qword [rbp-2304]
	mov r8,qword [r8+8]
	mov qword [rbp-2304],r8
	mov r8,qword [rbp-1528]
	mov r9,r8
	mov qword [rbp-1360],r9
	mov r8,qword [rbp-2304]
	mov r9,qword [rbp-1360]
	add r9,r8
	mov qword [rbp-1360],r9
	mov r8,qword [rbp-1360]
	mov r9,r8
	mov qword [rbp-576],r9
	mov r8,qword [rbp-840]
	mov r9,r8
	mov qword [rbp-608],r9
	mov r8,qword [rbp-608]
	add r8,0
	mov qword [rbp-608],r8
	mov r8,qword [rbp-608]
	mov r9,r8
	mov qword [rbp-1056],r9
	mov r8,qword [rbp-1056]
	mov r8,qword [r8+8]
	mov qword [rbp-1056],r8
	mov r8,qword [rbp-1056]
	mov r9,r8
	mov qword [rbp-280],r9
	mov r8,qword [rbp-280]
	add r8,16
	mov qword [rbp-280],r8
	mov r8,qword [rbp-280]
	mov r9,r8
	mov qword [rbp-184],r9
	mov r8,qword [rbp-184]
	mov r8,qword [r8+8]
	mov qword [rbp-184],r8
	mov r8,qword [rbp-576]
	mov r9,r8
	mov qword [rbp-432],r9
	mov r8,qword [rbp-184]
	mov r9,qword [rbp-432]
	add r9,r8
	mov qword [rbp-432],r9
	mov r8,qword [rbp-432]
	mov r9,r8
	mov qword [rbp-672],r9
	mov r8,qword [rbp-672]
	mov r9,qword [rbp-856]
	cmp r8,r9
	mov r10,0
	sete r10b
	mov qword [rbp-1848],r10
	mov r8,qword [rbp-1848]
	mov r9,r8
	mov qword [rbp-928],r9
	jmp ___search..lhs_merge_12
___search..lhs_merge_12:
	mov r8,qword [rbp-928]
	cmp r8b,1
	jz ___search..if_true_8
	jnz ___search..if_after_8
___search..if_true_8:
	mov r8,qword [rbp-288]
	mov r9,r8
	mov qword [rbp-2000],r9
	mov r8,qword [rbp-2000]
	add r8,0
	mov qword [rbp-2000],r8
	mov r8,qword [rbp-2000]
	mov r9,r8
	mov qword [rbp-624],r9
	mov r8,qword [rbp-624]
	mov r8,qword [r8+8]
	mov qword [rbp-624],r8
	mov r8,qword [rbp-624]
	mov r9,r8
	mov qword [rbp-592],r9
	mov r8,qword [rbp-592]
	add r8,1
	mov qword [rbp-592],r8
	mov r8,qword [rbp-592]
	mov r9,r8
	mov qword [rbp-1928],r9
	mov r8,qword [rbp-288]
	mov r9,r8
	mov qword [rbp-2248],r9
	mov r8,qword [rbp-2248]
	add r8,0
	mov qword [rbp-2248],r8
	mov r8,qword [rbp-2248]
	mov r9,r8
	mov qword [rbp-1048],r9
	mov r8,qword [rbp-1048]
	mov r9,qword [rbp-1928]
	mov qword [r8+8],r9
	mov r8,0
	mov qword [rbp-472],r8
	jmp ___search..for_cond_2
___search..for_cond_2:
	mov r8,qword [rbp-472]
	cmp r8,2
	mov r9,0
	setle r9b
	mov qword [rbp-1184],r9
	mov r8,qword [rbp-1184]
	cmp r8b,1
	jz ___search..for_loop_2
	jnz ___search..for_after_2
___search..for_loop_2:
	mov r8,0
	mov qword [rbp-1000],r8
	jmp ___search..for_cond_3
___search..for_cond_3:
	mov r8,qword [rbp-1000]
	cmp r8,2
	mov r9,0
	setle r9b
	mov qword [rbp-2320],r9
	mov r8,qword [rbp-2320]
	cmp r8b,1
	jz ___search..for_loop_3
	jnz ___search..for_after_3
___search..for_after_3:
	mov qword [rbp-2400],r8
	mov qword [rbp-2408],r10
	mov qword [rbp-2416],r9
	mov rdi,qword [rbp-16]
	call _Z5printPc
	mov r9,qword [rbp-2416]
	mov r10,qword [rbp-2408]
	mov r8,qword [rbp-2400]
	jmp ___search..for_step_2
___search..for_step_2:
	mov r8,qword [rbp-472]
	mov r9,r8
	mov qword [rbp-2256],r9
	mov r8,qword [rbp-472]
	add r8,1
	mov qword [rbp-472],r8
	jmp ___search..for_cond_2
___search..for_loop_3:
	mov r8,qword [rbp-472]
	mov r9,r8
	mov qword [rbp-848],r9
	mov r8,qword [rbp-848]
	imul r8,8
	mov qword [rbp-848],r8
	mov r8,qword [rbp-848]
	mov r9,r8
	mov qword [rbp-2112],r9
	mov r8,qword [rbp-840]
	mov r9,qword [rbp-2112]
	add r9,r8
	mov qword [rbp-2112],r9
	mov r8,qword [rbp-2112]
	mov r8,qword [r8+8]
	mov qword [rbp-2112],r8
	mov r8,qword [rbp-1000]
	mov r9,r8
	mov qword [rbp-200],r9
	mov r8,qword [rbp-200]
	imul r8,8
	mov qword [rbp-200],r8
	mov r8,qword [rbp-200]
	mov r9,r8
	mov qword [rbp-344],r9
	mov r8,qword [rbp-2112]
	mov r9,qword [rbp-344]
	add r9,r8
	mov qword [rbp-344],r9
	mov r8,qword [rbp-344]
	mov r8,qword [r8+8]
	mov qword [rbp-344],r8
	mov qword [rbp-2400],r8
	mov qword [rbp-2408],r10
	mov qword [rbp-2416],r9
	mov rdi,qword [rbp-344]
	call _Z8printInti
	mov r9,qword [rbp-2416]
	mov r10,qword [rbp-2408]
	mov r8,qword [rbp-2400]
	mov qword [rbp-2400],r8
	mov qword [rbp-2408],r10
	mov qword [rbp-2416],r9
	mov rdi,qword [rbp-1832]
	call _Z5printPc
	mov r9,qword [rbp-2416]
	mov r10,qword [rbp-2408]
	mov r8,qword [rbp-2400]
	jmp ___search..for_step_3
___search..for_step_3:
	mov r8,qword [rbp-1000]
	mov r9,r8
	mov qword [rbp-1400],r9
	mov r8,qword [rbp-1000]
	add r8,1
	mov qword [rbp-1000],r8
	jmp ___search..for_cond_3
___search..for_after_2:
	mov qword [rbp-2400],r8
	mov qword [rbp-2408],r10
	mov qword [rbp-2416],r9
	mov rdi,qword [rbp-16]
	call _Z5printPc
	mov r9,qword [rbp-2416]
	mov r10,qword [rbp-2408]
	mov r8,qword [rbp-2400]
	jmp ___search..if_after_8
___search..if_after_8:
	jmp ___search..if_after_7
___search..if_after_7:
	jmp ___search..if_after
___search..if_after:
	mov rax,0
	leave
	ret

main:
main..main.entry:
	push rbp
	mov rbp,rsp
	sub rsp,112
	mov r8,qword [___count]
	mov qword [rbp-40],r8
	mov qword [rbp-48],r8
	mov qword [rbp-56],r9
	call ____init
	mov r9,qword [rbp-56]
	mov r8,qword [rbp-48]
	mov r8,qword [___count]
	mov qword [rbp-40],r8
	mov qword [rbp-48],r8
	mov qword [rbp-56],r9
	mov qword [rbp-64],rdi
	mov rdi,3
	call ___origin
	mov rdi,qword [rbp-64]
	mov r9,qword [rbp-56]
	mov r8,qword [rbp-48]
	mov r8,rax
	mov qword [rbp-24],r8
	mov qword [rbp-48],r8
	mov qword [rbp-56],r9
	mov qword [rbp-64],rdi
	mov qword [rbp-72],rsi
	mov qword [rbp-80],rdx
	mov rdx,0
	mov rsi,0
	mov rdi,0
	call ___search
	mov rdx,qword [rbp-80]
	mov rsi,qword [rbp-72]
	mov rdi,qword [rbp-64]
	mov r9,qword [rbp-56]
	mov r8,qword [rbp-48]
	mov r8,rax
	mov qword [rbp-16],r8
	mov r8,qword [rbp-40]
	mov r9,r8
	mov qword [rbp-32],r9
	mov r8,qword [rbp-32]
	add r8,0
	mov qword [rbp-32],r8
	mov r8,qword [rbp-32]
	mov r9,r8
	mov qword [rbp-8],r9
	mov r8,qword [rbp-8]
	mov r8,qword [r8+8]
	mov qword [rbp-8],r8
	mov qword [rbp-48],r8
	mov qword [rbp-56],r9
	mov rdi,qword [rbp-8]
	call _Z10printlnInti
	mov r9,qword [rbp-56]
	mov r8,qword [rbp-48]
	mov rax,0
	leave
	ret

____init:
____init.._init.entry:
	push rbp
	mov rbp,rsp
	sub rsp,128
	mov r8,qword [___i]
	mov qword [rbp-16],r8
	mov r8,qword [___count]
	mov qword [rbp-24],r8
	mov r8,qword [___make]
	mov qword [rbp-40],r8
	mov r8,qword [___color]
	mov qword [rbp-56],r8
	mov r8,qword [___j]
	mov qword [rbp-8],r8
	mov r8,0
	mov qword [rbp-40],r8
	mov r8,88
	mov qword [rbp-32],r8
	mov r8,qword [rbp-32]
	mov rdi,r8
	call malloc
	mov r8,rax
	mov qword [rbp-32],r8
	mov r8,qword [rbp-32]
	mov qword [r8],10
	mov r8,qword [rbp-32]
	mov r9,r8
	mov qword [rbp-56],r9
	mov r8,16
	mov qword [rbp-48],r8
	mov r8,qword [rbp-48]
	mov rdi,r8
	call malloc
	mov r8,rax
	mov qword [rbp-48],r8
	mov r8,qword [rbp-48]
	mov qword [r8],1
	mov r8,qword [rbp-48]
	mov r9,r8
	mov qword [rbp-24],r9
	mov r8,0
	mov qword [rbp-16],r8
	mov r8,0
	mov qword [rbp-8],r8
	mov r8,qword [rbp-16]
	mov qword [___i],r8
	mov r8,qword [rbp-24]
	mov qword [___count],r8
	mov r8,qword [rbp-40]
	mov qword [___make],r8
	mov r8,qword [rbp-56]
	mov qword [___color],r8
	mov r8,qword [rbp-8]
	mov qword [___j],r8
	leave
	ret

	section .data
___string_2:
	db 1,0,0,0,0,0,0,0,32,0
___string:
	db 1,0,0,0,0,0,0,0,10,0

section .bss
___make:
	resb 64
___color:
	resb 64
___count:
	resb 64
___i:
	resb 64
___j:
	resb 64






default rel

global _Z15stringSubStringPcii
global _Z14stringParseIntPc
global _Z12stringConcatPcS_
global _Z9stringEquPcS_
global _Z10stringLessPcS_
global _Z9stringLeqPcS_
global _Z5printPc
global _Z7printlnPc
global _Z8printInti
global _Z10printlnInti
global _Z9getStringv
global _Z6getIntv
global _Z8toStringi

extern _IO_getc
extern stdin
extern scanf
extern __stack_chk_fail
extern _IO_putc
extern stdout
extern puts
extern __printf_chk
extern strcmp
extern memcpy
extern malloc


SECTION .text 

_Z15stringSubStringPcii:
        push    r15
        push    r14
        push    r13
        movsxd  r13, esi
        push    r12
        push    rbp
        push    rbx
        mov     ebx, edx
        sub     ebx, r13d
        mov     r12, rdi
        lea     edi, [rbx+0AH]
        lea     r15d, [rbx+1H]
        sub     rsp, 8
        movsxd  rdi, edi
        movsxd  r14, r15d
        call    malloc
        test    r15d, r15d
        mov     rbp, rax
        mov     qword [rax], r14
        jle     L_001
        mov     edx, ebx
        lea     rdi, [rax+8H]
        lea     rsi, [r12+r13+8H]
        add     rdx, 1
        call    memcpy
L_001:  mov     byte [rbp+r14+8H], 0
        add     rsp, 8
        mov     rax, rbp
        pop     rbx
        pop     rbp
        pop     r12
        pop     r13
        pop     r14
        pop     r15
        ret







ALIGN   16

_Z14stringParseIntPc:
        xor     edx, edx
        cmp     byte [rdi+8H], 45
        sete    dl
        setne   r8b
        sete    al
        movsx   edx, byte [rdi+rdx+8H]
        movzx   r8d, r8b
        movzx   eax, al
        lea     r8d, [r8+r8-1H]
        lea     ecx, [rdx-30H]
        cmp     cl, 9
        ja      L_003
        lea     rcx, [rdi+rax+9H]
        xor     eax, eax
L_002:  lea     esi, [rax+rax*4]
        add     rcx, 1
        lea     eax, [rdx+rsi*2-30H]
        movsx   edx, byte [rcx-1H]
        lea     esi, [rdx-30H]
        cmp     sil, 9
        jbe     L_002
        imul    eax, r8d
        ret

L_003:  xor     eax, eax
        ret


_Z12stringConcatPcS_:
        push    r15
        push    r14
        push    r13
        push    r12
        mov     r13, rsi
        push    rbp
        push    rbx
        sub     rsp, 24
        mov     rbx, qword [rdi]
        mov     rbp, qword [rsi]
        mov     qword [rsp+8H], rdi
        lea     r15d, [rbp+rbx]
        lea     edi, [r15+9H]
        movsxd  r15, r15d
        movsxd  rdi, edi
        call    malloc
        test    ebx, ebx
        mov     r12, rax
        mov     qword [rax], r15
        mov     rcx, qword [rsp+8H]
        jle     L_006
        lea     edx, [rbx-1H]
        lea     rdi, [rax+8H]
        lea     rsi, [rcx+8H]
        mov     r14d, ebx
        movsxd  rbx, ebx
        add     rdx, 1
        call    memcpy
L_004:  test    ebp, ebp
        jle     L_005
        movsxd  rax, r14d
        lea     edx, [rbp-1H]
        lea     ebx, [r14+rbp]
        lea     rdi, [r12+rax+8H]
        lea     rsi, [r13+8H]
        add     rdx, 1
        movsxd  rbx, ebx
        call    memcpy
L_005:  mov     byte [r12+rbx+8H], 0
        add     rsp, 24
        mov     rax, r12
        pop     rbx
        pop     rbp
        pop     r12
        pop     r13
        pop     r14
        pop     r15
        ret





ALIGN   8
L_006:  xor     ebx, ebx
        xor     r14d, r14d
        jmp     L_004


        nop

ALIGN   16
_Z9stringEquPcS_:
        sub     rsp, 8
        add     rsi, 8
        add     rdi, 8
        call    strcmp
        test    eax, eax
        sete    al
        add     rsp, 8
        movzx   eax, al
        ret






ALIGN   8

_Z10stringLessPcS_:
        sub     rsp, 8
        add     rsi, 8
        add     rdi, 8
        call    strcmp
        add     rsp, 8
        shr     eax, 31
        ret






ALIGN   8

_Z9stringLeqPcS_:
        sub     rsp, 8
        add     rsi, 8
        add     rdi, 8
        call    strcmp
        test    eax, eax
        setle   al
        add     rsp, 8
        movzx   eax, al
        ret






ALIGN   8

_Z5printPc:
        lea     rdx, [rdi+8H]
        mov     esi, L_060
        mov     edi, 1
        xor     eax, eax
        jmp     __printf_chk


        nop





ALIGN   16

_Z7printlnPc:
        add     rdi, 8
        jmp     puts






ALIGN   8

_Z8printInti:
        push    rbx
        sub     rsp, 48


        mov     rax, qword [fs:abs 28H]
        mov     qword [rsp+28H], rax
        xor     eax, eax
        test    edi, edi
        je      L_010
        mov     ebx, edi
        js      L_011
L_007:  mov     eax, ebx
        mov     esi, 1717986919
        mov     ecx, ebx
        imul    esi
        sar     ecx, 31
        sar     edx, 2
        sub     edx, ecx
        lea     eax, [rdx+rdx*4]
        mov     edi, edx
        mov     edx, ebx
        add     eax, eax
        sub     edx, eax
        test    edi, edi
        mov     dword [rsp], edx
        je      L_018
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+4H], edi
        mov     edi, 1374389535
        imul    edi
        sar     edx, 5
        mov     edi, edx
        sub     edi, ecx
        je      L_016
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+8H], edi
        mov     edi, 274877907
        imul    edi
        sar     edx, 6
        mov     edi, edx
        sub     edi, ecx
        je      L_017
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+0CH], edi
        mov     edi, 1759218605
        imul    edi
        sar     edx, 12
        mov     edi, edx
        sub     edi, ecx
        je      L_012
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+10H], edi
        mov     edi, 351843721
        imul    edi
        sar     edx, 13
        mov     edi, edx
        sub     edi, ecx
        je      L_013
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+14H], edi
        mov     edi, 1125899907
        imul    edi
        sar     edx, 18
        mov     edi, edx
        sub     edi, ecx
        je      L_014
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+18H], edi
        mov     edi, 1801439851
        imul    edi
        sar     edx, 22
        mov     edi, edx
        sub     edi, ecx
        je      L_015
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+1CH], edi
        mov     edi, 1441151881
        imul    edi
        sar     edx, 25
        mov     edi, edx
        sub     edi, ecx
        je      L_019
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        mov     esi, edx
        mov     edx, 1152921505
        sar     esi, 2
        sub     esi, eax
        lea     eax, [rsi+rsi*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        imul    edx
        mov     dword [rsp+20H], edi
        sar     edx, 28
        sub     edx, ecx
        je      L_020
        mov     dword [rsp+24H], edx
        mov     ebx, 10
L_008:  sub     ebx, 1




ALIGN   8
L_009:  movsxd  rax, ebx
        mov     rsi, qword [rel stdout]
        sub     ebx, 1
        mov     edi, dword [rsp+rax*4]
        add     edi, 48
        call    _IO_putc
        cmp     ebx, -1
        jnz     L_009
        mov     rax, qword [rsp+28H]


        xor     rax, qword [fs:abs 28H]
        jne     L_021
        add     rsp, 48
        pop     rbx
        ret





ALIGN   8
L_010:  mov     rax, qword [rsp+28H]


        xor     rax, qword [fs:abs 28H]
        jne     L_021
        mov     rsi, qword [rel stdout]
        add     rsp, 48
        mov     edi, 48
        pop     rbx
        jmp     _IO_putc





ALIGN   8
L_011:  mov     rsi, qword [rel stdout]
        mov     edi, 45
        neg     ebx
        call    _IO_putc
        jmp     L_007

L_012:  mov     ebx, 4
        jmp     L_008

L_013:  mov     ebx, 5
        jmp     L_008

L_014:  mov     ebx, 6
        jmp     L_008

L_015:  mov     ebx, 7
        jmp     L_008

L_016:  mov     ebx, 2
        jmp     L_008

L_017:  mov     ebx, 3
        jmp     L_008

L_018:  mov     ebx, 1
        jmp     L_008

L_019:  mov     ebx, 8
        jmp     L_008

L_020:  mov     ebx, 9
        jmp     L_008

L_021:  call    __stack_chk_fail





ALIGN   16

_Z10printlnInti:
        push    rbx
        sub     rsp, 48


        mov     rax, qword [fs:abs 28H]
        mov     qword [rsp+28H], rax
        xor     eax, eax
        test    edi, edi
        je      L_026
        mov     ebx, edi
        js      L_027
L_022:  mov     eax, ebx
        mov     esi, 1717986919
        mov     ecx, ebx
        imul    esi
        sar     ecx, 31
        sar     edx, 2
        sub     edx, ecx
        lea     eax, [rdx+rdx*4]
        mov     edi, edx
        mov     edx, ebx
        add     eax, eax
        sub     edx, eax
        test    edi, edi
        mov     dword [rsp], edx
        je      L_034
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+4H], edi
        mov     edi, 1374389535
        imul    edi
        sar     edx, 5
        mov     edi, edx
        sub     edi, ecx
        je      L_032
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+8H], edi
        mov     edi, 274877907
        imul    edi
        sar     edx, 6
        mov     edi, edx
        sub     edi, ecx
        je      L_033
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+0CH], edi
        mov     edi, 1759218605
        imul    edi
        sar     edx, 12
        mov     edi, edx
        sub     edi, ecx
        je      L_028
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+10H], edi
        mov     edi, 351843721
        imul    edi
        sar     edx, 13
        mov     edi, edx
        sub     edi, ecx
        je      L_029
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+14H], edi
        mov     edi, 1125899907
        imul    edi
        sar     edx, 18
        mov     edi, edx
        sub     edi, ecx
        je      L_030
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+18H], edi
        mov     edi, 1801439851
        imul    edi
        sar     edx, 22
        mov     edi, edx
        sub     edi, ecx
        je      L_031
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+1CH], edi
        mov     edi, 1441151881
        imul    edi
        sar     edx, 25
        mov     edi, edx
        sub     edi, ecx
        je      L_035
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        mov     esi, edx
        mov     edx, 1152921505
        sar     esi, 2
        sub     esi, eax
        lea     eax, [rsi+rsi*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        imul    edx
        mov     dword [rsp+20H], edi
        sar     edx, 28
        sub     edx, ecx
        je      L_036
        mov     dword [rsp+24H], edx
        mov     ebx, 10
L_023:  sub     ebx, 1




ALIGN   8
L_024:  movsxd  rax, ebx
        mov     rsi, qword [rel stdout]
        sub     ebx, 1
        mov     edi, dword [rsp+rax*4]
        add     edi, 48
        call    _IO_putc
        cmp     ebx, -1
        jnz     L_024
L_025:  mov     rax, qword [rsp+28H]


        xor     rax, qword [fs:abs 28H]
        jne     L_037
        mov     rsi, qword [rel stdout]
        add     rsp, 48
        mov     edi, 10
        pop     rbx
        jmp     _IO_putc





ALIGN   8
L_026:  mov     rsi, qword [rel stdout]
        mov     edi, 48
        call    _IO_putc
        jmp     L_025





ALIGN   8
L_027:  mov     rsi, qword [rel stdout]
        mov     edi, 45
        neg     ebx
        call    _IO_putc
        jmp     L_022

L_028:  mov     ebx, 4
        jmp     L_023

L_029:  mov     ebx, 5
        jmp     L_023

L_030:  mov     ebx, 6
        jmp     L_023

L_031:  mov     ebx, 7
        jmp     L_023

L_032:  mov     ebx, 2
        jmp     L_023

L_033:  mov     ebx, 3
        jmp     L_023

L_034:  mov     ebx, 1
        jmp     L_023

L_035:  mov     ebx, 8
        jmp     L_023

L_036:  mov     ebx, 9
        jmp     L_023

L_037:  call    __stack_chk_fail
        nop
ALIGN   16

_Z9getStringv:
        push    rbp
        push    rbx
        mov     edi, 300
        sub     rsp, 8
        call    malloc
        lea     rbx, [rax+8H]
        mov     rbp, rax
        mov     edi, L_060
        xor     eax, eax
        mov     rsi, rbx
        call    scanf
        mov     rdx, rbx
L_038:  mov     ecx, dword [rdx]
        add     rdx, 4
        lea     eax, [rcx-1010101H]
        not     ecx
        and     eax, ecx
        and     eax, 80808080H
        jz      L_038
        mov     ecx, eax
        shr     ecx, 16
        test    eax, 8080H
        cmove   eax, ecx
        lea     rcx, [rdx+2H]
        mov     esi, eax
        cmove   rdx, rcx
        add     sil, al
        mov     rax, rbp
        sbb     rdx, 3
        sub     rdx, rbx
        mov     qword [rbp], rdx
        add     rsp, 8
        pop     rbx
        pop     rbp
        ret


        nop

ALIGN   16
_Z6getIntv:
        push    rbp
        push    rbx
        sub     rsp, 8
        jmp     L_040





ALIGN   16
L_039:  cmp     al, 45
        jz      L_041
L_040:  mov     rdi, qword [rel stdin]
        call    _IO_getc
        lea     ecx, [rax-30H]
        movsx   edx, al
        cmp     cl, 9
        ja      L_039
L_041:  cmp     dl, 45
        mov     ebp, 1
        jz      L_044
L_042:  xor     ebx, ebx





ALIGN   16
L_043:  mov     rdi, qword [rel stdin]
        lea     eax, [rbx+rbx*4]
        lea     ebx, [rdx+rax*2-30H]
        call    _IO_getc
        movsx   edx, al
        sub     eax, 48
        cmp     al, 9
        jbe     L_043
        mov     eax, ebx
        add     rsp, 8
        imul    eax, ebp
        pop     rbx
        pop     rbp
        ret





ALIGN   8
L_044:  mov     rdi, qword [rel stdin]
        mov     ebp, 4294967295
        call    _IO_getc
        movsx   edx, al
        jmp     L_042







ALIGN   16

_Z8toStringi:
        push    rbp
        push    rbx
        sub     rsp, 72


        mov     rax, qword [fs:abs 28H]
        mov     qword [rsp+38H], rax
        xor     eax, eax
        test    edi, edi
        js      L_046
        jne     L_049
        mov     edi, 10
        call    malloc
        movzx   ebx, byte [rsp]
        mov     qword [rax], 1
        mov     byte [rax+9H], 0
        lea     edx, [rbx+30H]
        mov     byte [rax+8H], dl
L_045:  mov     rbx, qword [rsp+38H]


        xor     rbx, qword [fs:abs 28H]
        jne     L_059
        add     rsp, 72
        pop     rbx
        pop     rbp
        ret





ALIGN   8
L_046:  neg     edi
        mov     r9d, 1
L_047:  mov     eax, edi
        mov     esi, 1717986919
        mov     ecx, edi
        imul    esi
        sar     ecx, 31
        mov     ebx, edi
        sar     edx, 2
        sub     edx, ecx
        lea     eax, [rdx+rdx*4]
        mov     r8d, edx
        add     eax, eax
        sub     ebx, eax
        test    edx, edx
        mov     dword [rsp+4H], ebx
        je      L_050
        mov     eax, edx
        imul    esi
        mov     eax, r8d
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     r8d, eax
        mov     eax, edi
        mov     dword [rsp+8H], r8d
        mov     r8d, 1374389535
        imul    r8d
        sar     edx, 5
        mov     r8d, edx
        sub     r8d, ecx
        je      L_051
        mov     eax, r8d
        imul    esi
        mov     eax, r8d
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     r8d, eax
        mov     eax, edi
        mov     dword [rsp+0CH], r8d
        mov     r8d, 274877907
        imul    r8d
        sar     edx, 6
        mov     r8d, edx
        sub     r8d, ecx
        je      L_052
        mov     eax, r8d
        imul    esi
        mov     eax, r8d
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     r8d, eax
        mov     eax, edi
        mov     dword [rsp+10H], r8d
        mov     r8d, 1759218605
        imul    r8d
        sar     edx, 12
        mov     r8d, edx
        sub     r8d, ecx
        je      L_053
        mov     eax, r8d
        imul    esi
        mov     eax, r8d
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     r8d, eax
        mov     eax, edi
        mov     dword [rsp+14H], r8d
        mov     r8d, 351843721
        imul    r8d
        sar     edx, 13
        mov     r8d, edx
        sub     r8d, ecx
        je      L_054
        mov     eax, r8d
        imul    esi
        mov     eax, r8d
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     r8d, eax
        mov     eax, edi
        mov     dword [rsp+18H], r8d
        mov     r8d, 1125899907
        imul    r8d
        sar     edx, 18
        mov     r8d, edx
        sub     r8d, ecx
        je      L_055
        mov     eax, r8d
        imul    esi
        mov     eax, r8d
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     r8d, eax
        mov     eax, edi
        mov     dword [rsp+1CH], r8d
        mov     r8d, 1801439851
        imul    r8d
        sar     edx, 22
        mov     r8d, edx
        sub     r8d, ecx
        je      L_056
        mov     eax, r8d
        imul    esi
        mov     eax, r8d
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     r8d, eax
        mov     eax, edi
        mov     dword [rsp+20H], r8d
        mov     r8d, 1441151881
        imul    r8d
        sar     edx, 25
        mov     r8d, edx
        sub     r8d, ecx
        je      L_057
        mov     eax, r8d
        imul    esi
        mov     eax, r8d
        sar     eax, 31
        mov     esi, edx
        mov     edx, 1152921505
        sar     esi, 2
        sub     esi, eax
        lea     eax, [rsi+rsi*4]
        add     eax, eax
        sub     r8d, eax
        mov     eax, edi
        imul    edx
        mov     dword [rsp+24H], r8d
        sar     edx, 28
        sub     edx, ecx
        je      L_058
        mov     dword [rsp+28H], edx
        mov     ebx, 9
        mov     ebp, 10
L_048:  lea     edi, [r9+rbp+9H]
        movsxd  rdi, edi
        call    malloc
        movsxd  rsi, ebx
        mov     qword [rax], rbp
        mov     byte [rax+rbp+8H], 0
        movzx   edi, byte [rsp+rsi*4]
        lea     ecx, [rdi+30H]
        mov     byte [rax+rsi+8H], cl
        lea     ecx, [rbx-1H]
        cmp     ecx, -1
        je      L_045
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-2H]
        cmp     ecx, -1
        je      L_045
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-3H]
        cmp     ecx, -1
        je      L_045
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-4H]
        cmp     ecx, -1
        je      L_045
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-5H]
        cmp     ecx, -1
        je      L_045
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-6H]
        cmp     ecx, -1
        je      L_045
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-7H]
        cmp     ecx, -1
        je      L_045
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-8H]
        cmp     ecx, -1
        je      L_045
        movsxd  rcx, ecx
        movzx   esi, byte [rsp+rcx*4]
        add     esi, 48
        cmp     ebx, 8
        mov     byte [rax+rcx+8H], sil
        je      L_045
        movzx   ebx, byte [rsp]
        lea     edx, [rbx+30H]
        mov     byte [rax+8H], dl
        jmp     L_045






ALIGN   16
L_049:  xor     r9d, r9d
        jmp     L_047





ALIGN   16
L_050:  xor     ebx, ebx
        mov     ebp, 1
        jmp     L_048





ALIGN   8
L_051:  mov     ebx, 1
        mov     ebp, 2
        jmp     L_048





ALIGN   8
L_052:  mov     ebx, 2
        mov     ebp, 3
        jmp     L_048





ALIGN   8
L_053:  mov     ebx, 3
        mov     ebp, 4
        jmp     L_048





ALIGN   8
L_054:  mov     ebx, 4
        mov     ebp, 5
        jmp     L_048





ALIGN   8
L_055:  mov     ebx, 5
        mov     ebp, 6
        jmp     L_048





ALIGN   8
L_056:  mov     ebx, 6
        mov     ebp, 7
        jmp     L_048





ALIGN   8
L_057:  mov     ebx, 7
        mov     ebp, 8
        jmp     L_048





ALIGN   8
L_058:  mov     ebx, 8
        mov     ebp, 9
        jmp     L_048

L_059:

        call    __stack_chk_fail



SECTION .data   


SECTION .bss    


SECTION .text.unlikely 


SECTION .rodata.str1.1 

L_060:
        db 25H, 73H, 00H


