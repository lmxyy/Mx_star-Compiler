global main

extern malloc
section .text

___hex2int:
___hex2int..hex2int.entry:
	push rbp
	mov rbp,rsp
	sub rsp,48
	mov r13,0
	mov r14,0
	mov r13,0
	jmp ___hex2int..for_cond
___hex2int..for_cond:
	mov rdx,qword [rdi]
	cmp r13,rdx
	mov rdx,0
	setl dl
	cmp dl,1
	jz ___hex2int..for_loop
	jnz ___hex2int..for_after
___hex2int..for_loop:
	mov qword [rsp],rdx
	mov qword [rsp+16],rdi
	mov rsi,r13
	mov rdi,qword [rsp+16]
	call _Z9stringOrdPci
	mov rdi,qword [rsp+16]
	mov rdx,qword [rsp]
	mov r12,rax
	cmp r12,48
	mov rdx,0
	setge dl
	cmp dl,1
	jz ___hex2int..lhs_true
	jnz ___hex2int..lhs_false
___hex2int..lhs_false:
	mov rdx,0
	jmp ___hex2int..lhs_merge
___hex2int..lhs_true:
	cmp r12,57
	mov rdx,0
	setle dl
	jmp ___hex2int..lhs_merge
___hex2int..lhs_merge:
	cmp dl,1
	jz ___hex2int..if_true
	jnz ___hex2int..if_false
___hex2int..if_false:
	cmp r12,65
	mov rdx,0
	setge dl
	cmp dl,1
	jz ___hex2int..lhs_true_2
	jnz ___hex2int..lhs_false_2
___hex2int..lhs_false_2:
	mov rdx,0
	jmp ___hex2int..lhs_merge_2
___hex2int..lhs_true_2:
	cmp r12,70
	mov rdx,0
	setle dl
	jmp ___hex2int..lhs_merge_2
___hex2int..lhs_merge_2:
	cmp dl,1
	jz ___hex2int..if_true_2
	jnz ___hex2int..if_false_2
___hex2int..if_false_2:
	cmp r12,97
	mov rdx,0
	setge dl
	cmp dl,1
	jz ___hex2int..lhs_true_3
	jnz ___hex2int..lhs_false_3
___hex2int..lhs_true_3:
	cmp r12,102
	mov rdx,0
	setle dl
	jmp ___hex2int..lhs_merge_3
___hex2int..lhs_false_3:
	mov rdx,0
	jmp ___hex2int..lhs_merge_3
___hex2int..lhs_merge_3:
	cmp dl,1
	jz ___hex2int..if_true_3
	jnz ___hex2int..if_false_3
___hex2int..if_false_3:
	mov rdx,0
	jmp ___hex2int..hex2int.exit
___hex2int..if_true_3:
	mov rdx,r14
	imul rdx,16
	add rdx,r12
	sub rdx,97
	add rdx,10
	mov r14,rdx
	jmp ___hex2int..if_after
___hex2int..if_after:
	jmp ___hex2int..if_after_2
___hex2int..if_true_2:
	mov rdx,r14
	imul rdx,16
	add rdx,r12
	sub rdx,65
	add rdx,10
	mov r14,rdx
	jmp ___hex2int..if_after_2
___hex2int..if_after_2:
	jmp ___hex2int..if_after_3
___hex2int..if_true:
	mov rdx,r14
	imul rdx,16
	add rdx,r12
	sub rdx,48
	mov r14,rdx
	jmp ___hex2int..if_after_3
___hex2int..if_after_3:
	jmp ___hex2int..for_step
___hex2int..for_step:
	mov rdx,r13
	add r13,1
	jmp ___hex2int..for_cond
___hex2int..for_after:
	mov rdx,r14
	jmp ___hex2int..hex2int.exit
___hex2int..hex2int.exit:
	mov rax,rdx
	leave
	ret

___sha1:
___sha1..sha1.entry:
	push rbp
	mov rbp,rsp
	sub rsp,272
	mov r10,qword [___outputBuffer]
	mov qword [rsp+8],r10
	mov rdx,qword [___MAXCHUNK]
	mov r10,___string
	mov qword [rsp+136],r10
	mov r10,qword [___chunks]
	mov qword [rsp+72],r10
	mov rbx,rsi
	add rbx,64
	sub rbx,56
	mov rax,rbx
	mov r11,rdx
	cqo
	mov r10,64
	idiv r10
	mov rdx,r11
	mov r10,rax
	mov qword [rsp+80],r10
	mov r10,qword [rsp+80]
	mov rbx,r10
	add rbx,1
	mov r10,rbx
	mov qword [rsp+128],r10
	mov r10,qword [rsp+128]
	cmp r10,rdx
	mov rdx,0
	setg dl
	cmp dl,1
	jz ___sha1..if_true
	jnz ___sha1..if_after
___sha1..if_true:
	mov qword [rsp+176],rdx
	mov qword [rsp+192],rdi
	mov qword [rsp+216],r9
	mov qword [rsp+224],r8
	mov qword [rsp+232],rsi
	mov qword [rsp+256],rcx
	mov rdi,qword [rsp+136]
	call _Z7printlnPc
	mov rcx,qword [rsp+256]
	mov rsi,qword [rsp+232]
	mov r8,qword [rsp+224]
	mov r9,qword [rsp+216]
	mov rdi,qword [rsp+192]
	mov rdx,qword [rsp+176]
	mov rdx,0
	jmp ___sha1..sha1.exit
___sha1..if_after:
	mov r10,0
	mov qword [rsp+120],r10
	mov rbx,0
	mov r10,0
	mov qword [rsp+120],r10
	jmp ___sha1..for_cond
___sha1..for_cond:
	mov r10,qword [rsp+120]
	mov r11,qword [rsp+128]
	cmp r10,r11
	mov rdx,0
	setl dl
	cmp dl,1
	jz ___sha1..for_loop
	jnz ___sha1..for_after
___sha1..for_loop:
	mov rbx,0
	jmp ___sha1..for_cond_2
___sha1..for_cond_2:
	cmp rbx,80
	mov rdx,0
	setl dl
	cmp dl,1
	jz ___sha1..for_loop_2
	jnz ___sha1..for_after_2
___sha1..for_after_2:
	jmp ___sha1..for_step
___sha1..for_step:
	mov r10,qword [rsp+120]
	mov rdx,r10
	mov r10,qword [rsp+120]
	add r10,1
	mov qword [rsp+120],r10
	jmp ___sha1..for_cond
___sha1..for_loop_2:
	mov r10,qword [rsp+120]
	mov rdx,r10
	imul rdx,8
	mov r10,qword [rsp+72]
	add rdx,r10
	mov rdx,qword [rdx+8]
	mov r10,rbx
	mov qword [rsp+168],r10
	mov r10,qword [rsp+168]
	imul r10,8
	mov qword [rsp+168],r10
	mov r10,qword [rsp+168]
	add r10,rdx
	mov qword [rsp+168],r10
	mov r10,qword [rsp+168]
	mov qword [r10+8],0
	jmp ___sha1..for_step_2
___sha1..for_step_2:
	mov rdx,rbx
	add rbx,1
	jmp ___sha1..for_cond_2
___sha1..for_after:
	mov r10,0
	mov qword [rsp+120],r10
	jmp ___sha1..for_cond_3
___sha1..for_cond_3:
	mov r10,qword [rsp+120]
	cmp r10,rsi
	mov rdx,0
	setl dl
	cmp dl,1
	jz ___sha1..for_loop_3
	jnz ___sha1..for_after_3
___sha1..for_after_3:
	mov r10,qword [rsp+120]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,64
	idiv r10
	mov rdx,r11
	mov r15,rax
	imul r15,8
	mov r10,qword [rsp+72]
	add r15,r10
	mov r15,qword [r15+8]
	mov r10,qword [rsp+120]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,64
	idiv r10
	mov rdi,rdx
	mov rdx,r11
	mov rax,rdi
	mov r11,rdx
	cqo
	mov r10,4
	idiv r10
	mov rdx,r11
	mov r10,rax
	mov qword [rsp+32],r10
	mov r10,qword [rsp+32]
	mov rdx,r10
	imul rdx,8
	add rdx,r15
	mov rdx,qword [rdx+8]
	mov r10,qword [rsp+120]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,4
	idiv r10
	mov r13,rdx
	mov rdx,r11
	mov rdi,3
	sub rdi,r13
	imul rdi,8
	mov r11,rcx
	mov rcx,rdi
	mov rax,128
	sal rax,cl
	mov r13,rax
	mov rcx,r11
	or rdx,r13
	mov r10,qword [rsp+120]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,64
	idiv r10
	mov rdx,r11
	mov r14,rax
	imul r14,8
	mov r10,qword [rsp+72]
	add r14,r10
	mov r14,qword [r14+8]
	mov r10,qword [rsp+120]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,64
	idiv r10
	mov r10,rdx
	mov qword [rsp+56],r10
	mov rdx,r11
	mov r10,qword [rsp+56]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,4
	idiv r10
	mov rdx,r11
	mov r10,rax
	mov qword [rsp+144],r10
	mov r10,qword [rsp+144]
	mov r13,r10
	imul r13,8
	add r13,r14
	mov qword [r13+8],rdx
	mov r13,rsi
	sal r13,3
	mov r10,qword [rsp+128]
	mov rdx,r10
	sub rdx,1
	imul rdx,8
	mov r10,qword [rsp+72]
	add rdx,r10
	mov rdx,qword [rdx+8]
	add rdx,120
	mov qword [rdx+8],r13
	sar rsi,29
	mov r13,rsi
	and r13,7
	mov r10,qword [rsp+128]
	mov rdx,r10
	sub rdx,1
	imul rdx,8
	mov r10,qword [rsp+72]
	add rdx,r10
	mov rdx,qword [rdx+8]
	add rdx,112
	mov qword [rdx+8],r13
	mov r14,1732584193
	mov rcx,43913
	mov rdx,61389
	sal rdx,16
	or rcx,rdx
	jmp ___sha1..lohi.entry
___sha1..lohi.entry:
	mov r13,56574
	mov rdx,39098
	sal rdx,16
	or r13,rdx
	jmp ___sha1..lohi.entry_2
___sha1..lohi.entry_2:
	mov rdx,r13
	mov r10,rdx
	mov qword [rsp+64],r10
	mov r10,271733878
	mov qword [rsp+104],r10
	mov rsi,57840
	mov rdx,50130
	sal rdx,16
	or rsi,rdx
	jmp ___sha1..lohi.entry_3
___sha1..lohi.entry_3:
	mov r10,0
	mov qword [rsp+120],r10
	jmp ___sha1..for_cond_4
___sha1..for_cond_4:
	mov r10,qword [rsp+120]
	mov r11,qword [rsp+128]
	cmp r10,r11
	mov rdx,0
	setl dl
	cmp dl,1
	jz ___sha1..for_loop_4
	jnz ___sha1..for_after_4
___sha1..for_loop_4:
	mov rbx,16
	jmp ___sha1..for_cond_5
___sha1..for_cond_5:
	cmp rbx,80
	mov rdx,0
	setl dl
	cmp dl,1
	jz ___sha1..for_loop_5
	jnz ___sha1..for_after_5
___sha1..for_after_5:
	mov r10,r14
	mov qword [rsp+16],r10
	mov r12,rcx
	mov r10,qword [rsp+64]
	mov qword [rsp+160],r10
	mov r10,qword [rsp+104]
	mov qword [rsp+152],r10
	mov r15,rsi
	mov rbx,0
	jmp ___sha1..for_cond_6
___sha1..for_cond_6:
	cmp rbx,80
	mov rdx,0
	setl dl
	cmp dl,1
	jz ___sha1..for_loop_6
	jnz ___sha1..for_after_6
___sha1..for_after_6:
	mov r10,qword [rsp+16]
	mov rdi,r10
	mov r13,r14
	and r13,65535
	mov rdx,rdi
	and rdx,65535
	add r13,rdx
	mov rdx,r13
	sar r14,16
	mov r13,r14
	and r13,65535
	sar rdi,16
	and rdi,65535
	add r13,rdi
	mov rdi,rdx
	sar rdi,16
	add r13,rdi
	and r13,65535
	sal r13,16
	and rdx,65535
	or r13,rdx
	jmp ___sha1..add.entry
___sha1..add.entry:
	mov r14,r13
	mov r13,rcx
	and r13,65535
	mov rdx,r12
	and rdx,65535
	add r13,rdx
	mov rdx,rcx
	sar rdx,16
	and rdx,65535
	mov rdi,r12
	sar rdi,16
	and rdi,65535
	add rdx,rdi
	mov rdi,r13
	sar rdi,16
	add rdx,rdi
	and rdx,65535
	sal rdx,16
	and r13,65535
	or rdx,r13
	jmp ___sha1..add.entry_2
___sha1..add.entry_2:
	mov rcx,rdx
	mov r10,qword [rsp+64]
	mov r12,r10
	mov r10,qword [rsp+160]
	mov rdi,r10
	mov r13,r12
	and r13,65535
	mov rdx,rdi
	and rdx,65535
	add r13,rdx
	sar r12,16
	mov rdx,r12
	and rdx,65535
	sar rdi,16
	and rdi,65535
	add rdx,rdi
	mov rdi,r13
	sar rdi,16
	add rdx,rdi
	and rdx,65535
	sal rdx,16
	and r13,65535
	or rdx,r13
	jmp ___sha1..add.entry_3
___sha1..add.entry_3:
	mov r10,rdx
	mov qword [rsp+64],r10
	mov r10,qword [rsp+104]
	mov rdi,r10
	mov r10,qword [rsp+152]
	mov r13,r10
	mov rdx,rdi
	and rdx,65535
	mov r12,r13
	and r12,65535
	add rdx,r12
	sar rdi,16
	and rdi,65535
	sar r13,16
	and r13,65535
	add rdi,r13
	mov r13,rdx
	sar r13,16
	add rdi,r13
	and rdi,65535
	mov r13,rdi
	sal r13,16
	and rdx,65535
	or r13,rdx
	jmp ___sha1..add.entry_4
___sha1..add.entry_4:
	mov rdx,r13
	mov r10,rdx
	mov qword [rsp+104],r10
	mov r13,rsi
	and r13,65535
	mov rdx,r15
	and rdx,65535
	add r13,rdx
	sar rsi,16
	mov rdx,rsi
	and rdx,65535
	mov rdi,r15
	sar rdi,16
	and rdi,65535
	add rdx,rdi
	mov rdi,r13
	sar rdi,16
	add rdx,rdi
	and rdx,65535
	sal rdx,16
	and r13,65535
	or rdx,r13
	jmp ___sha1..add.entry_5
___sha1..add.entry_5:
	mov rsi,rdx
	jmp ___sha1..for_step_3
___sha1..for_step_3:
	mov r10,qword [rsp+120]
	mov rdx,r10
	mov r10,qword [rsp+120]
	add r10,1
	mov qword [rsp+120],r10
	jmp ___sha1..for_cond_4
___sha1..for_loop_6:
	mov r9,0
	mov r8,0
	cmp rbx,20
	mov rdx,0
	setl dl
	cmp dl,1
	jz ___sha1..if_true_2
	jnz ___sha1..if_false
___sha1..if_true_2:
	mov r9,r12
	mov r10,qword [rsp+160]
	and r9,r10
	mov rdx,r12
	not rdx
	mov r10,qword [rsp+152]
	and rdx,r10
	or r9,rdx
	mov r8,1518500249
	jmp ___sha1..if_after_2
___sha1..if_false:
	cmp rbx,40
	mov rdx,0
	setl dl
	cmp dl,1
	jz ___sha1..if_true_3
	jnz ___sha1..if_false_2
___sha1..if_true_3:
	mov rdx,r12
	mov r10,qword [rsp+160]
	xor rdx,r10
	mov r9,rdx
	mov r10,qword [rsp+152]
	xor r9,r10
	mov r8,1859775393
	jmp ___sha1..if_after_3
___sha1..if_false_2:
	cmp rbx,60
	mov rdx,0
	setl dl
	cmp dl,1
	jz ___sha1..if_true_4
	jnz ___sha1..if_false_3
___sha1..if_false_3:
	mov rdx,r12
	mov r10,qword [rsp+160]
	xor rdx,r10
	mov r10,qword [rsp+152]
	xor rdx,r10
	mov r9,rdx
	mov r13,49622
	mov rdx,51810
	sal rdx,16
	or r13,rdx
	jmp ___sha1..lohi.entry_4
___sha1..lohi.entry_4:
	mov r8,r13
	jmp ___sha1..if_after_4
___sha1..if_true_4:
	mov r13,r12
	mov r10,qword [rsp+160]
	and r13,r10
	mov rdx,r12
	mov r10,qword [rsp+152]
	and rdx,r10
	or r13,rdx
	mov r10,qword [rsp+160]
	mov rdx,r10
	mov r10,qword [rsp+152]
	and rdx,r10
	mov r9,r13
	or r9,rdx
	mov rdx,48348
	mov r13,36635
	sal r13,16
	or rdx,r13
	jmp ___sha1..lohi.entry_5
___sha1..lohi.entry_5:
	mov r8,rdx
	jmp ___sha1..if_after_4
___sha1..if_after_4:
	jmp ___sha1..if_after_3
___sha1..if_after_3:
	jmp ___sha1..if_after_2
___sha1..if_after_2:
	mov r10,qword [rsp+16]
	mov rdx,r10
	mov rdi,5
	cmp rdi,1
	mov r13,0
	sete r13b
	cmp r13b,1
	jz ___sha1..if_true_5
	jnz ___sha1..if_after_5
___sha1..if_after_5:
	cmp rdi,31
	mov r13,0
	sete r13b
	cmp r13b,1
	jz ___sha1..if_true_6
	jnz ___sha1..if_after_6
___sha1..if_true_6:
	mov r13,rdx
	and r13,1
	sal r13,31
	sar rdx,1
	and rdx,2147483647
	mov rdi,r13
	or rdi,rdx
	jmp ___sha1..rotate_left.exit
___sha1..if_after_6:
	mov r13,32
	sub r13,rdi
	mov r11,rcx
	mov rcx,r13
	mov rax,1
	sal rax,cl
	mov r13,rax
	mov rcx,r11
	sub r13,1
	mov r10,r13
	mov qword [rsp+96],r10
	mov r13,rdx
	mov r10,qword [rsp+96]
	and r13,r10
	mov r11,rcx
	mov rcx,rdi
	mov rax,r13
	sal rax,cl
	mov r10,rax
	mov qword [rsp+112],r10
	mov rcx,r11
	mov r13,32
	sub r13,rdi
	mov r11,rcx
	mov rcx,r13
	mov rax,rdx
	sar rax,cl
	mov rdx,rax
	mov rcx,r11
	mov r11,rcx
	mov rcx,rdi
	mov rax,1
	sal rax,cl
	mov r13,rax
	mov rcx,r11
	sub r13,1
	mov rdi,r13
	mov r13,rdx
	and r13,rdi
	mov r10,qword [rsp+112]
	mov rdx,r10
	or rdx,r13
	mov rdi,rdx
	jmp ___sha1..rotate_left.exit
___sha1..if_true_5:
	mov r13,rdx
	and r13,2147483647
	sal r13,1
	sar rdx,31
	and rdx,1
	or r13,rdx
	mov rdi,r13
	jmp ___sha1..rotate_left.exit
___sha1..rotate_left.exit:
	mov rdx,rdi
	and rdx,65535
	mov r13,r15
	and r13,65535
	add rdx,r13
	sar rdi,16
	and rdi,65535
	sar r15,16
	and r15,65535
	mov r13,rdi
	add r13,r15
	mov rdi,rdx
	sar rdi,16
	add r13,rdi
	and r13,65535
	sal r13,16
	and rdx,65535
	or r13,rdx
	jmp ___sha1..add.entry_6
___sha1..add.entry_6:
	mov r15,r13
	mov rdx,r9
	and rdx,65535
	mov r13,r8
	and r13,65535
	add rdx,r13
	mov r13,r9
	sar r13,16
	and r13,65535
	mov rdi,r8
	sar rdi,16
	and rdi,65535
	add r13,rdi
	mov rdi,rdx
	sar rdi,16
	add r13,rdi
	and r13,65535
	sal r13,16
	and rdx,65535
	or r13,rdx
	jmp ___sha1..add.entry_7
___sha1..add.entry_7:
	mov rdi,r15
	and rdi,65535
	mov rdx,r13
	and rdx,65535
	add rdi,rdx
	mov rdx,r15
	sar rdx,16
	and rdx,65535
	sar r13,16
	mov r9,r13
	and r9,65535
	mov r13,rdx
	add r13,r9
	mov rdx,rdi
	sar rdx,16
	add r13,rdx
	and r13,65535
	sal r13,16
	mov rdx,rdi
	and rdx,65535
	or r13,rdx
	jmp ___sha1..add.entry_8
___sha1..add.entry_8:
	mov r10,qword [rsp+120]
	mov rdx,r10
	imul rdx,8
	mov r10,qword [rsp+72]
	add rdx,r10
	mov rdx,qword [rdx+8]
	mov r9,rbx
	imul r9,8
	add r9,rdx
	mov r9,qword [r9+8]
	mov rdi,r13
	mov r13,rdi
	and r13,65535
	mov rdx,r9
	and rdx,65535
	add r13,rdx
	mov r8,r13
	mov rdx,rdi
	sar rdx,16
	and rdx,65535
	sar r9,16
	and r9,65535
	add rdx,r9
	mov r13,r8
	sar r13,16
	add rdx,r13
	and rdx,65535
	sal rdx,16
	and r8,65535
	or rdx,r8
	jmp ___sha1..add.entry_9
___sha1..add.entry_9:
	mov r10,qword [rsp+152]
	mov r15,r10
	mov r10,qword [rsp+160]
	mov qword [rsp+152],r10
	mov rdi,30
	cmp rdi,1
	mov r13,0
	sete r13b
	cmp r13b,1
	jz ___sha1..if_true_7
	jnz ___sha1..if_after_7
___sha1..if_true_7:
	mov r13,r12
	and r13,2147483647
	sal r13,1
	mov rdi,r12
	sar rdi,31
	and rdi,1
	or r13,rdi
	jmp ___sha1..rotate_left.exit_2
___sha1..if_after_7:
	cmp rdi,31
	mov r13,0
	sete r13b
	cmp r13b,1
	jz ___sha1..if_true_8
	jnz ___sha1..if_after_8
___sha1..if_true_8:
	mov rdi,r12
	and rdi,1
	sal rdi,31
	mov r13,r12
	sar r13,1
	and r13,2147483647
	or rdi,r13
	mov r13,rdi
	jmp ___sha1..rotate_left.exit_2
___sha1..if_after_8:
	mov r13,32
	sub r13,rdi
	mov r11,rcx
	mov rcx,r13
	mov rax,1
	sal rax,cl
	mov r13,rax
	mov rcx,r11
	mov r9,r13
	sub r9,1
	mov r13,r12
	and r13,r9
	mov r11,rcx
	mov rcx,rdi
	mov rax,r13
	sal rax,cl
	mov r13,rax
	mov rcx,r11
	mov r9,32
	sub r9,rdi
	mov r11,rcx
	mov rcx,r9
	mov rax,r12
	sar rax,cl
	mov r12,rax
	mov rcx,r11
	mov r11,rcx
	mov rcx,rdi
	mov rax,1
	sal rax,cl
	mov rdi,rax
	mov rcx,r11
	sub rdi,1
	and r12,rdi
	or r13,r12
	jmp ___sha1..rotate_left.exit_2
___sha1..rotate_left.exit_2:
	mov r10,r13
	mov qword [rsp+160],r10
	mov r10,qword [rsp+16]
	mov r12,r10
	mov r10,rdx
	mov qword [rsp+16],r10
	jmp ___sha1..for_step_4
___sha1..for_step_4:
	mov rdx,rbx
	add rbx,1
	jmp ___sha1..for_cond_6
___sha1..for_loop_5:
	mov r10,qword [rsp+120]
	mov rdx,r10
	imul rdx,8
	mov r10,qword [rsp+72]
	add rdx,r10
	mov rdx,qword [rdx+8]
	mov r13,rbx
	sub r13,3
	imul r13,8
	add r13,rdx
	mov r13,qword [r13+8]
	mov r10,qword [rsp+120]
	mov rdi,r10
	imul rdi,8
	mov r10,qword [rsp+72]
	add rdi,r10
	mov rdi,qword [rdi+8]
	mov rdx,rbx
	sub rdx,8
	imul rdx,8
	add rdx,rdi
	mov rdx,qword [rdx+8]
	xor r13,rdx
	mov r10,qword [rsp+120]
	mov rdi,r10
	imul rdi,8
	mov r10,qword [rsp+72]
	add rdi,r10
	mov rdi,qword [rdi+8]
	mov rdx,rbx
	sub rdx,14
	imul rdx,8
	add rdx,rdi
	mov rdx,qword [rdx+8]
	xor r13,rdx
	mov r10,qword [rsp+120]
	mov rdi,r10
	imul rdi,8
	mov r10,qword [rsp+72]
	add rdi,r10
	mov rdi,qword [rdi+8]
	mov rdx,rbx
	sub rdx,16
	imul rdx,8
	add rdx,rdi
	mov rdx,qword [rdx+8]
	xor r13,rdx
	mov rdi,r13
	mov r13,1
	cmp r13,1
	mov rdx,0
	sete dl
	cmp dl,1
	jz ___sha1..if_true_9
	jnz ___sha1..if_after_9
___sha1..if_true_9:
	mov rdx,rdi
	and rdx,2147483647
	sal rdx,1
	mov r13,rdi
	sar r13,31
	and r13,1
	or rdx,r13
	mov r12,rdx
	jmp ___sha1..rotate_left.exit_3
___sha1..if_after_9:
	cmp r13,31
	mov rdx,0
	sete dl
	cmp dl,1
	jz ___sha1..if_true_10
	jnz ___sha1..if_after_10
___sha1..if_true_10:
	mov rdx,rdi
	and rdx,1
	sal rdx,31
	sar rdi,1
	and rdi,2147483647
	or rdx,rdi
	mov r12,rdx
	jmp ___sha1..rotate_left.exit_3
___sha1..if_after_10:
	mov rdx,32
	sub rdx,r13
	mov r11,rcx
	mov rcx,rdx
	mov rax,1
	sal rax,cl
	mov r12,rax
	mov rcx,r11
	sub r12,1
	mov rdx,rdi
	and rdx,r12
	mov r11,rcx
	mov rcx,r13
	mov rax,rdx
	sal rax,cl
	mov r12,rax
	mov rcx,r11
	mov rdx,32
	sub rdx,r13
	mov r11,rcx
	mov rcx,rdx
	mov rax,rdi
	sar rax,cl
	mov rdx,rax
	mov rcx,r11
	mov r11,rcx
	mov rcx,r13
	mov rax,1
	sal rax,cl
	mov r13,rax
	mov rcx,r11
	sub r13,1
	and rdx,r13
	or r12,rdx
	jmp ___sha1..rotate_left.exit_3
___sha1..rotate_left.exit_3:
	mov r13,r12
	mov r10,qword [rsp+120]
	mov rdx,r10
	imul rdx,8
	mov r10,qword [rsp+72]
	add rdx,r10
	mov rdx,qword [rdx+8]
	mov rdi,rbx
	imul rdi,8
	add rdi,rdx
	mov qword [rdi+8],r13
	jmp ___sha1..for_step_5
___sha1..for_step_5:
	mov rdx,rbx
	add rbx,1
	jmp ___sha1..for_cond_5
___sha1..for_after_4:
	mov r10,qword [rsp+8]
	mov rdx,r10
	add rdx,0
	mov qword [rdx+8],r14
	mov r10,qword [rsp+8]
	mov rdx,r10
	add rdx,8
	mov qword [rdx+8],rcx
	mov r10,qword [rsp+8]
	mov rdx,r10
	add rdx,16
	mov r10,qword [rsp+64]
	mov qword [rdx+8],r10
	mov r10,qword [rsp+8]
	mov rdx,r10
	add rdx,24
	mov r10,qword [rsp+104]
	mov qword [rdx+8],r10
	mov r10,qword [rsp+8]
	mov rdx,r10
	add rdx,32
	mov qword [rdx+8],rsi
	mov r10,qword [rsp+8]
	mov rdx,r10
	jmp ___sha1..sha1.exit
___sha1..sha1.exit:
	mov rax,rdx
	leave
	ret
___sha1..for_loop_3:
	mov r10,qword [rsp+120]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,64
	idiv r10
	mov rdx,r11
	mov r10,rax
	mov qword [rsp+40],r10
	mov r10,qword [rsp+40]
	mov rdx,r10
	imul rdx,8
	mov r10,qword [rsp+72]
	add rdx,r10
	mov rdx,qword [rdx+8]
	mov r10,qword [rsp+120]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,64
	idiv r10
	mov rcx,rdx
	mov rdx,r11
	mov rax,rcx
	mov r11,rdx
	cqo
	mov r10,4
	idiv r10
	mov rdx,r11
	mov r12,rax
	mov r10,r12
	mov qword [rsp+48],r10
	mov r10,qword [rsp+48]
	imul r10,8
	mov qword [rsp+48],r10
	mov r10,qword [rsp+48]
	add r10,rdx
	mov qword [rsp+48],r10
	mov r10,qword [rsp+48]
	mov r10,qword [r10+8]
	mov qword [rsp+48],r10
	mov r10,qword [rsp+120]
	mov rdx,r10
	imul rdx,8
	add rdx,rdi
	mov rdx,qword [rdx+8]
	mov r10,qword [rsp+120]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,4
	idiv r10
	mov r9,rdx
	mov rdx,r11
	mov rbx,3
	sub rbx,r9
	imul rbx,8
	mov r11,rcx
	mov rcx,rbx
	mov rax,rdx
	sal rax,cl
	mov rdx,rax
	mov rcx,r11
	mov r10,qword [rsp+48]
	mov qword [rsp+24],r10
	mov r10,qword [rsp+24]
	or r10,rdx
	mov qword [rsp+24],r10
	mov r10,qword [rsp+120]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,64
	idiv r10
	mov rdx,r11
	mov r8,rax
	mov rdx,r8
	imul rdx,8
	mov r10,qword [rsp+72]
	add rdx,r10
	mov rdx,qword [rdx+8]
	mov r10,qword [rsp+120]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,64
	idiv r10
	mov r10,rdx
	mov qword [rsp+88],r10
	mov rdx,r11
	mov r10,qword [rsp+88]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,4
	idiv r10
	mov rdx,r11
	mov r10,rax
	mov qword [rsp],r10
	mov r10,qword [rsp]
	mov rbx,r10
	imul rbx,8
	add rbx,rdx
	mov r10,qword [rsp+24]
	mov qword [rbx+8],r10
	jmp ___sha1..for_step_6
___sha1..for_step_6:
	mov r10,qword [rsp+120]
	mov rdx,r10
	mov r10,qword [rsp+120]
	add r10,1
	mov qword [rsp+120],r10
	jmp ___sha1..for_cond_3

___nextText:
___nextText..nextText.entry:
	push rbp
	mov rbp,rsp
	sub rsp,48
	mov r13,0
	mov rdx,rsi
	sub rdx,1
	mov r13,rdx
	jmp ___nextText..for_cond
___nextText..for_cond:
	cmp r13,0
	mov rdx,0
	setge dl
	cmp dl,1
	jz ___nextText..for_loop
	jnz ___nextText..for_after
___nextText..for_loop:
	mov rdx,r13
	imul rdx,8
	add rdx,rdi
	mov rdx,qword [rdx+8]
	mov r12,rdx
	cmp r12,122
	mov rdx,0
	sete dl
	cmp dl,1
	jz ___nextText..if_true
	jnz ___nextText..if_after
___nextText..if_true:
	mov rdx,-1
	jmp ___nextText..nextLetter.exit
___nextText..if_after:
	cmp r12,90
	mov rdx,0
	sete dl
	cmp dl,1
	jz ___nextText..if_true_2
	jnz ___nextText..if_after_2
___nextText..if_after_2:
	cmp r12,57
	mov rdx,0
	sete dl
	cmp dl,1
	jz ___nextText..if_true_3
	jnz ___nextText..if_after_3
___nextText..if_after_3:
	mov rdx,r12
	add rdx,1
	jmp ___nextText..nextLetter.exit
___nextText..if_true_3:
	mov rdx,65
	jmp ___nextText..nextLetter.exit
___nextText..if_true_2:
	mov rdx,97
	jmp ___nextText..nextLetter.exit
___nextText..nextLetter.exit:
	mov r12,r13
	imul r12,8
	add r12,rdi
	mov qword [r12+8],rdx
	mov r12,r13
	imul r12,8
	add r12,rdi
	mov r12,qword [r12+8]
	mov rdx,-1
	cmp r12,rdx
	mov rdx,0
	sete dl
	cmp dl,1
	jz ___nextText..if_true_4
	jnz ___nextText..if_false
___nextText..if_false:
	mov rdx,1
	jmp ___nextText..nextText.exit
___nextText..if_true_4:
	mov rdx,r13
	imul rdx,8
	add rdx,rdi
	mov qword [rdx+8],48
	jmp ___nextText..if_after_4
___nextText..if_after_4:
	jmp ___nextText..for_step
___nextText..for_step:
	mov rdx,r13
	mov rdx,r13
	sub rdx,1
	mov r13,rdx
	jmp ___nextText..for_cond
___nextText..for_after:
	mov rdx,0
	jmp ___nextText..nextText.exit
___nextText..nextText.exit:
	mov rax,rdx
	leave
	ret

main:
main..main.entry:
	push rbp
	mov rbp,rsp
	sub rsp,112
	mov rsi,qword [___MAXLENGTH]
	mov r10,qword [___outputBuffer]
	mov qword [rsp+16],r10
	mov rdx,___string_2
	mov r13,qword [___MAXCHUNK]
	mov r14,qword [___asciiTable]
	mov r12,qword [___inputBuffer]
	mov rdi,___string_3
	mov r15,qword [___chunks]
	mov r14,rdx
	mov r13,100
	mov rdx,r13
	sub rdx,1
	imul rdx,64
	sub rdx,16
	mov rsi,rdx
	mov r15,r13
	imul r15,8
	add r15,8
	mov qword [rsp+24],rdx
	mov qword [rsp+40],rdi
	mov qword [rsp+64],r9
	mov qword [rsp+72],r8
	mov qword [rsp+80],rsi
	mov qword [rsp+96],rcx
	mov rdi,r15
	call malloc
	mov rcx,qword [rsp+96]
	mov rsi,qword [rsp+80]
	mov r8,qword [rsp+72]
	mov r9,qword [rsp+64]
	mov rdi,qword [rsp+40]
	mov rdx,qword [rsp+24]
	mov r15,rax
	mov qword [r15],r13
	mov r12,0
	jmp main..for_cond
main..for_cond:
	cmp r12,r13
	mov rdx,0
	setl dl
	cmp dl,1
	jz main..for_loop
	jnz main..for_after
main..for_loop:
	mov r9,648
	mov qword [rsp+24],rdx
	mov qword [rsp+40],rdi
	mov qword [rsp+64],r9
	mov qword [rsp+72],r8
	mov qword [rsp+80],rsi
	mov qword [rsp+96],rcx
	mov rdi,r9
	call malloc
	mov rcx,qword [rsp+96]
	mov rsi,qword [rsp+80]
	mov r8,qword [rsp+72]
	mov r9,qword [rsp+64]
	mov rdi,qword [rsp+40]
	mov rdx,qword [rsp+24]
	mov r9,rax
	mov qword [r9],80
	mov rdx,r12
	imul rdx,8
	add rdx,r15
	mov qword [rdx+8],r9
	jmp main..for_step
main..for_step:
	add r12,1
	jmp main..for_cond
main..for_after:
	mov r12,rsi
	imul r12,8
	add r12,8
	mov qword [rsp+24],rdx
	mov qword [rsp+40],rdi
	mov qword [rsp+64],r9
	mov qword [rsp+72],r8
	mov qword [rsp+80],rsi
	mov qword [rsp+96],rcx
	mov rdi,r12
	call malloc
	mov rcx,qword [rsp+96]
	mov rsi,qword [rsp+80]
	mov r8,qword [rsp+72]
	mov r9,qword [rsp+64]
	mov rdi,qword [rsp+40]
	mov rdx,qword [rsp+24]
	mov r12,rax
	mov qword [r12],rsi
	mov rdx,48
	mov qword [rsp+24],rdx
	mov qword [rsp+40],rdi
	mov qword [rsp+64],r9
	mov qword [rsp+72],r8
	mov qword [rsp+80],rsi
	mov qword [rsp+96],rcx
	mov rdi,rdx
	call malloc
	mov rcx,qword [rsp+96]
	mov rsi,qword [rsp+80]
	mov r8,qword [rsp+72]
	mov r9,qword [rsp+64]
	mov rdi,qword [rsp+40]
	mov rdx,qword [rsp+24]
	mov rdx,rax
	mov qword [rdx],5
	mov r10,rdx
	mov qword [rsp+16],r10
	mov rdx,0
	mov rdx,0
	jmp main..while_cond
main..while_cond:
	jmp main..while_loop
main..while_loop:
	mov qword [rsp+24],rdx
	mov qword [rsp+40],rdi
	mov qword [rsp+64],r9
	mov qword [rsp+72],r8
	mov qword [rsp+80],rsi
	mov qword [rsp+96],rcx
	call _Z6getIntv
	mov rcx,qword [rsp+96]
	mov rsi,qword [rsp+80]
	mov r8,qword [rsp+72]
	mov r9,qword [rsp+64]
	mov rdi,qword [rsp+40]
	mov rdx,qword [rsp+24]
	mov rdx,rax
	cmp rdx,0
	mov r9,0
	sete r9b
	cmp r9b,1
	jz main..if_true
	jnz main..if_after
main..if_after:
	cmp rdx,1
	mov r9,0
	sete r9b
	cmp r9b,1
	jz main..if_true_2
	jnz main..if_false
main..if_false:
	cmp rdx,2
	mov rdx,0
	sete dl
	cmp dl,1
	jz main..if_true_3
	jnz main..if_after_2
main..if_true_3:
	mov qword [rsp+24],rdx
	mov qword [rsp+40],rdi
	mov qword [rsp+64],r9
	mov qword [rsp+72],r8
	mov qword [rsp+80],rsi
	mov qword [rsp+96],rcx
	call _Z9getStringv
	mov rcx,qword [rsp+96]
	mov rsi,qword [rsp+80]
	mov r8,qword [rsp+72]
	mov r9,qword [rsp+64]
	mov rdi,qword [rsp+40]
	mov rdx,qword [rsp+24]
	mov rdx,rax
	jmp main..crackSHA1.entry
main..crackSHA1.entry:
	jmp main..if_after_2
main..if_after_2:
	jmp main..if_after_3
main..if_true_2:
	mov qword [rsp+24],rdx
	mov qword [rsp+40],rdi
	mov qword [rsp+64],r9
	mov qword [rsp+72],r8
	mov qword [rsp+80],rsi
	mov qword [rsp+96],rcx
	call _Z9getStringv
	mov rcx,qword [rsp+96]
	mov rsi,qword [rsp+80]
	mov r8,qword [rsp+72]
	mov r9,qword [rsp+64]
	mov rdi,qword [rsp+40]
	mov rdx,qword [rsp+24]
	mov rdx,rax
	mov r8,0
	mov r8,0
	jmp main..for_cond_2
main..for_cond_2:
	mov r9,qword [rdx]
	cmp r8,r9
	mov r9,0
	setl r9b
	cmp r9b,1
	jz main..for_loop_2
	jnz main..for_after_2
main..for_loop_2:
	mov qword [rsp+24],rdx
	mov qword [rsp+40],rdi
	mov qword [rsp+64],r9
	mov qword [rsp+72],r8
	mov qword [rsp+80],rsi
	mov qword [rsp+96],rcx
	mov rsi,qword [rsp+72]
	mov rdi,qword [rsp+24]
	call _Z9stringOrdPci
	mov rcx,qword [rsp+96]
	mov rsi,qword [rsp+80]
	mov r8,qword [rsp+72]
	mov r9,qword [rsp+64]
	mov rdi,qword [rsp+40]
	mov rdx,qword [rsp+24]
	mov rcx,rax
	mov r9,r8
	imul r9,8
	add r9,r12
	mov qword [r9+8],rcx
	jmp main..for_step_2
main..for_step_2:
	mov r9,r8
	add r8,1
	jmp main..for_cond_2
main..for_after_2:
	mov rdx,qword [rdx]
	mov r10,qword [rsp+16]
	mov qword [___outputBuffer],r10
	mov qword [___MAXCHUNK],r13
	mov qword [___chunks],r15
	mov qword [rsp+24],rdx
	mov qword [rsp+32],r13
	mov qword [rsp+40],rdi
	mov qword [rsp+48],r14
	mov qword [rsp+56],r12
	mov qword [rsp+64],r9
	mov qword [rsp+72],r8
	mov qword [rsp+80],rsi
	mov qword [rsp+88],r15
	mov qword [rsp+96],rcx
	mov qword [rsp+104],rbx
	mov rsi,qword [rsp+24]
	mov rdi,r12
	call ___sha1
	mov rbx,qword [rsp+104]
	mov rcx,qword [rsp+96]
	mov r15,qword [rsp+88]
	mov rsi,qword [rsp+80]
	mov r8,qword [rsp+72]
	mov r9,qword [rsp+64]
	mov r12,qword [rsp+56]
	mov r14,qword [rsp+48]
	mov rdi,qword [rsp+40]
	mov r13,qword [rsp+32]
	mov rdx,qword [rsp+24]
	mov rdx,rax
	mov r10,rdx
	mov qword [rsp],r10
	mov r8,0
	jmp main..for_cond_3
main..for_cond_3:
	mov r10,qword [rsp]
	mov rdx,qword [r10]
	cmp r8,rdx
	mov rdx,0
	setl dl
	cmp dl,1
	jz main..for_loop_3
	jnz main..for_after_3
main..for_after_3:
	mov qword [rsp+24],rdx
	mov qword [rsp+40],rdi
	mov qword [rsp+64],r9
	mov qword [rsp+72],r8
	mov qword [rsp+80],rsi
	mov qword [rsp+96],rcx
	mov rdi,qword [rsp+40]
	call _Z7printlnPc
	mov rcx,qword [rsp+96]
	mov rsi,qword [rsp+80]
	mov r8,qword [rsp+72]
	mov r9,qword [rsp+64]
	mov rdi,qword [rsp+40]
	mov rdx,qword [rsp+24]
	jmp main..if_after_3
main..if_after_3:
	jmp main..while_cond
main..for_loop_3:
	mov rdx,r8
	imul rdx,8
	mov r10,qword [rsp]
	add rdx,r10
	mov rdx,qword [rdx+8]
	mov r10,rdx
	mov qword [rsp+8],r10
	mov rbx,rdi
	mov rcx,0
	mov rcx,28
	jmp main..for_cond_4
main..for_cond_4:
	cmp rcx,0
	mov rdx,0
	setge dl
	cmp dl,1
	jz main..for_loop_4
	jnz main..for_after_4
main..for_loop_4:
	mov r11,rcx
	mov r10,qword [rsp+8]
	mov rax,r10
	sar rax,cl
	mov r9,rax
	mov rcx,r11
	and r9,15
	cmp r9,10
	mov rdx,0
	setl dl
	cmp dl,1
	jz main..if_true_4
	jnz main..if_false_2
main..if_true_4:
	add r9,48
	cmp r9,32
	mov rdx,0
	setge dl
	cmp dl,1
	jz main..lhs_true
	jnz main..lhs_false
main..lhs_true:
	cmp r9,126
	mov rdx,0
	setle dl
	jmp main..lhs_merge
main..lhs_false:
	mov rdx,0
	jmp main..lhs_merge
main..lhs_merge:
	cmp dl,1
	jz main..if_true_5
	jnz main..if_after_4
main..if_true_5:
	mov rdx,r9
	sub rdx,32
	sub r9,32
	mov qword [rsp+24],rdx
	mov qword [rsp+40],rdi
	mov qword [rsp+64],r9
	mov qword [rsp+72],r8
	mov qword [rsp+80],rsi
	mov qword [rsp+96],rcx
	mov rdx,qword [rsp+64]
	mov rsi,qword [rsp+24]
	mov rdi,r14
	call _Z15stringSubStringPcii
	mov rcx,qword [rsp+96]
	mov rsi,qword [rsp+80]
	mov r8,qword [rsp+72]
	mov r9,qword [rsp+64]
	mov rdi,qword [rsp+40]
	mov rdx,qword [rsp+24]
	mov rdx,rax
	jmp main..int2chr.exit
main..if_after_4:
	mov rdx,rdi
	jmp main..int2chr.exit
main..int2chr.exit:
	mov qword [rsp+24],rdx
	mov qword [rsp+40],rdi
	mov qword [rsp+64],r9
	mov qword [rsp+72],r8
	mov qword [rsp+80],rsi
	mov qword [rsp+96],rcx
	mov rsi,qword [rsp+24]
	mov rdi,rbx
	call _Z12stringConcatPcS_
	mov rcx,qword [rsp+96]
	mov rsi,qword [rsp+80]
	mov r8,qword [rsp+72]
	mov r9,qword [rsp+64]
	mov rdi,qword [rsp+40]
	mov rdx,qword [rsp+24]
	mov rbx,rax
	jmp main..if_after_5
main..if_false_2:
	add r9,65
	sub r9,10
	cmp r9,32
	mov rdx,0
	setge dl
	cmp dl,1
	jz main..lhs_true_2
	jnz main..lhs_false_2
main..lhs_true_2:
	cmp r9,126
	mov rdx,0
	setle dl
	jmp main..lhs_merge_2
main..lhs_false_2:
	mov rdx,0
	jmp main..lhs_merge_2
main..lhs_merge_2:
	cmp dl,1
	jz main..if_true_6
	jnz main..if_after_6
main..if_true_6:
	mov rdx,r9
	sub rdx,32
	sub r9,32
	mov qword [rsp+24],rdx
	mov qword [rsp+40],rdi
	mov qword [rsp+64],r9
	mov qword [rsp+72],r8
	mov qword [rsp+80],rsi
	mov qword [rsp+96],rcx
	mov rdx,qword [rsp+64]
	mov rsi,qword [rsp+24]
	mov rdi,r14
	call _Z15stringSubStringPcii
	mov rcx,qword [rsp+96]
	mov rsi,qword [rsp+80]
	mov r8,qword [rsp+72]
	mov r9,qword [rsp+64]
	mov rdi,qword [rsp+40]
	mov rdx,qword [rsp+24]
	mov rdx,rax
	jmp main..int2chr.exit_2
main..if_after_6:
	mov rdx,rdi
	jmp main..int2chr.exit_2
main..int2chr.exit_2:
	mov qword [rsp+24],rdx
	mov qword [rsp+40],rdi
	mov qword [rsp+64],r9
	mov qword [rsp+72],r8
	mov qword [rsp+80],rsi
	mov qword [rsp+96],rcx
	mov rsi,qword [rsp+24]
	mov rdi,rbx
	call _Z12stringConcatPcS_
	mov rcx,qword [rsp+96]
	mov rsi,qword [rsp+80]
	mov r8,qword [rsp+72]
	mov r9,qword [rsp+64]
	mov rdi,qword [rsp+40]
	mov rdx,qword [rsp+24]
	mov rbx,rax
	jmp main..if_after_5
main..if_after_5:
	jmp main..for_step_3
main..for_step_3:
	sub rcx,4
	jmp main..for_cond_4
main..for_after_4:
	mov qword [rsp+24],rdx
	mov qword [rsp+40],rdi
	mov qword [rsp+64],r9
	mov qword [rsp+72],r8
	mov qword [rsp+80],rsi
	mov qword [rsp+96],rcx
	mov rdi,rbx
	call _Z5printPc
	mov rcx,qword [rsp+96]
	mov rsi,qword [rsp+80]
	mov r8,qword [rsp+72]
	mov r9,qword [rsp+64]
	mov rdi,qword [rsp+40]
	mov rdx,qword [rsp+24]
	jmp main..for_step_4
main..for_step_4:
	mov rdx,r8
	add r8,1
	jmp main..for_cond_3
main..if_true:
	jmp main..while_after
main..while_after:
	mov qword [___MAXLENGTH],rsi
	mov r10,qword [rsp+16]
	mov qword [___outputBuffer],r10
	mov qword [___MAXCHUNK],r13
	mov qword [___asciiTable],r14
	mov qword [___inputBuffer],r12
	mov qword [___chunks],r15
	mov rax,0
	leave
	ret

section .data
___string_2:
	db 95,0,0,0,0,0,0,0,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,0
___string_3:
	db 0,0,0,0,0,0,0,0,0
___string:
	db 18,0,0,0,0,0,0,0,110,67,104,117,110,107,32,62,32,77,65,88,67,72,85,78,75,33,0

section .bss
___asciiTable:
	resb 64
___MAXCHUNK:
	resb 64
___MAXLENGTH:
	resb 64
___chunks:
	resb 64
___inputBuffer:
	resb 64
___outputBuffer:
	resb 64






default rel

global _Z15stringSubStringPcii
global _Z14stringParseIntPc
global _Z12stringConcatPcS_
global _Z9stringEquPcS_
global _Z10stringLessPcS_
global _Z9stringLeqPcS_
global _Z9stringOrdPci
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

_Z9stringOrdPci:
        movsxd  rsi, esi
        movsx   eax, byte [rdi+rsi+8H]
        ret






ALIGN   8

_Z5printPc:
        lea     rdx, [rdi+8H]
        mov     esi, L_061
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
        mov     edi, L_061
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
        push    r12
        push    rbp
        push    rbx
        sub     rsp, 64


        mov     rax, qword [fs:abs 28H]
        mov     qword [rsp+38H], rax
        xor     eax, eax
        test    edi, edi
        js      L_047
        jne     L_050
        mov     edi, 10
        mov     dword [rsp+4H], 0
        xor     ebp, ebp
        call    malloc
        lea     rdx, [rax+8H]
        mov     qword [rax], 1
        mov     byte [rax+9H], 0
        mov     ebx, 1
L_045:  movsxd  rcx, ebx
        movsxd  rsi, ebp
        mov     ecx, dword [rsp+rcx*4]
        add     ecx, 48
        cmp     ebx, 1
        mov     byte [rdx+rsi], cl
        je      L_046
        lea     esi, [rbx-1H]
        lea     ecx, [rbp+1H]
        movsxd  rsi, esi
        movsxd  rcx, ecx
        mov     esi, dword [rsp+rsi*4]
        add     esi, 48
        cmp     ebx, 2
        mov     byte [rdx+rcx], sil
        je      L_046
        lea     esi, [rbx-2H]
        lea     ecx, [rbp+2H]
        movsxd  rsi, esi
        movsxd  rcx, ecx
        mov     esi, dword [rsp+rsi*4]
        add     esi, 48
        cmp     ebx, 3
        mov     byte [rdx+rcx], sil
        je      L_046
        lea     esi, [rbx-3H]
        lea     ecx, [rbp+3H]
        movsxd  rsi, esi
        movsxd  rcx, ecx
        mov     esi, dword [rsp+rsi*4]
        add     esi, 48
        cmp     ebx, 4
        mov     byte [rdx+rcx], sil
        je      L_046
        lea     esi, [rbx-4H]
        lea     ecx, [rbp+4H]
        movsxd  rsi, esi
        movsxd  rcx, ecx
        mov     esi, dword [rsp+rsi*4]
        add     esi, 48
        cmp     ebx, 5
        mov     byte [rdx+rcx], sil
        je      L_046
        lea     esi, [rbx-5H]
        lea     ecx, [rbp+5H]
        movsxd  rsi, esi
        movsxd  rcx, ecx
        mov     esi, dword [rsp+rsi*4]
        add     esi, 48
        cmp     ebx, 6
        mov     byte [rdx+rcx], sil
        jz      L_046
        lea     esi, [rbx-6H]
        lea     ecx, [rbp+6H]
        movsxd  rsi, esi
        movsxd  rcx, ecx
        mov     esi, dword [rsp+rsi*4]
        add     esi, 48
        cmp     ebx, 7
        mov     byte [rdx+rcx], sil
        jz      L_046
        lea     esi, [rbx-7H]
        lea     ecx, [rbp+7H]
        movsxd  rsi, esi
        movsxd  rcx, ecx
        mov     esi, dword [rsp+rsi*4]
        add     esi, 48
        cmp     ebx, 8
        mov     byte [rdx+rcx], sil
        jz      L_046
        lea     esi, [rbx-8H]
        lea     ecx, [rbp+8H]
        movsxd  rsi, esi
        movsxd  rcx, ecx
        mov     esi, dword [rsp+rsi*4]
        add     esi, 48
        cmp     ebx, 9
        mov     byte [rdx+rcx], sil
        jz      L_046
        lea     esi, [rbx-9H]
        lea     ecx, [rbp+9H]
        movsxd  rsi, esi
        movsxd  rcx, ecx
        mov     esi, dword [rsp+rsi*4]
        add     esi, 48
        cmp     ebx, 10
        mov     byte [rdx+rcx], sil
        jz      L_046
        movzx   edi, byte [rsp+4H]
        add     ebp, 10
        movsxd  rbp, ebp
        lea     ecx, [rdi+30H]
        mov     byte [rdx+rbp], cl
L_046:  mov     rdi, qword [rsp+38H]


        xor     rdi, qword [fs:abs 28H]
        jne     L_060
        add     rsp, 64
        pop     rbx
        pop     rbp
        pop     r12
        ret






ALIGN   16
L_047:  neg     edi
        mov     ebp, 1
L_048:  mov     eax, edi
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
        je      L_051
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
        mov     dword [rsp+0CH], r8d
        mov     r8d, 274877907
        imul    r8d
        sar     edx, 6
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
        mov     dword [rsp+10H], r8d
        mov     r8d, 1759218605
        imul    r8d
        sar     edx, 12
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
        mov     dword [rsp+14H], r8d
        mov     r8d, 351843721
        imul    r8d
        sar     edx, 13
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
        mov     dword [rsp+18H], r8d
        mov     r8d, 1125899907
        imul    r8d
        sar     edx, 18
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
        mov     dword [rsp+1CH], r8d
        mov     r8d, 1801439851
        imul    r8d
        sar     edx, 22
        mov     r8d, edx
        sub     r8d, ecx
        je      L_057
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
        je      L_058
        mov     eax, r8d
        imul    esi
        mov     eax, r8d
        sar     eax, 31
        sar     edx, 2
        mov     esi, edx
        mov     edx, 1152921505
        sub     esi, eax
        lea     eax, [rsi+rsi*4]
        add     eax, eax
        sub     r8d, eax
        mov     eax, edi
        imul    edx
        mov     dword [rsp+24H], r8d
        sar     edx, 28
        sub     edx, ecx
        je      L_059
        mov     dword [rsp+28H], edx
        mov     ebx, 10
L_049:  lea     r12d, [rbp+rbx]
        lea     edi, [r12+9H]
        movsxd  r12, r12d
        movsxd  rdi, edi
        call    malloc
        test    ebp, ebp
        mov     qword [rax], r12
        lea     rdx, [rax+8H]
        mov     byte [rax+r12+8H], 0
        je      L_045
        mov     byte [rax+8H], 45
        mov     ebp, 1
        jmp     L_045






ALIGN   16
L_050:  xor     ebp, ebp
        jmp     L_048






ALIGN   16
L_051:  mov     ebx, 1
        jmp     L_049






ALIGN   16
L_052:  mov     ebx, 2
        jmp     L_049






ALIGN   16
L_053:  mov     ebx, 3
        jmp     L_049






ALIGN   16
L_054:  mov     ebx, 4
        jmp     L_049





ALIGN   8
L_055:  mov     ebx, 5
        jmp     L_049





ALIGN   8
L_056:  mov     ebx, 6
        jmp     L_049





ALIGN   8
L_057:  mov     ebx, 7
        jmp     L_049





ALIGN   8
L_058:  mov     ebx, 8
        jmp     L_049





ALIGN   8
L_059:  mov     ebx, 9
        jmp     L_049

L_060:

        call    __stack_chk_fail



SECTION .data   


SECTION .bss    


SECTION .text.unlikely 


SECTION .rodata.str1.1 

L_061:
        db 25H, 73H, 00H


