global main

extern malloc
section .text

___sha1:
___sha1..sha1.entry:
	push rbp
	mov rbp,rsp
	sub rsp,288
	mov qword [rsp+80],rdi
	mov qword [rsp+168],rsi
	mov r10,qword [rsp+80]
	mov qword [rsp+80],r10
	mov r10,qword [rsp+168]
	mov qword [rsp+168],r10
	mov r10,qword [___chunks]
	mov qword [rsp+56],r10
	mov r14,___string
	mov r8,qword [___outputBuffer]
	mov r10,qword [___MAXCHUNK]
	mov qword [rsp+160],r10
	mov r10,qword [rsp+168]
	mov rcx,r10
	add rcx,64
	sub rcx,56
	mov rax,rcx
	mov r11,rdx
	cqo
	mov r10,64
	idiv r10
	mov rdx,r11
	mov r9,rax
	add r9,1
	mov rcx,r9
	mov r10,qword [rsp+160]
	cmp rcx,r10
	mov r9,0
	setg r9b
	cmp r9b,1
	jz ___sha1..if_true
	jnz ___sha1..if_after
___sha1..if_after:
	mov r10,0
	mov qword [rsp+184],r10
	mov r10,0
	mov qword [rsp+176],r10
	mov r10,0
	mov qword [rsp+184],r10
	jmp ___sha1..for_cond
___sha1..for_cond:
	mov r10,qword [rsp+184]
	cmp r10,rcx
	mov r9,0
	setl r9b
	cmp r9b,1
	jz ___sha1..for_loop
	jnz ___sha1..for_after
___sha1..for_after:
	mov r10,0
	mov qword [rsp+184],r10
	jmp ___sha1..for_cond_2
___sha1..for_cond_2:
	mov r10,qword [rsp+184]
	mov r11,qword [rsp+168]
	cmp r10,r11
	mov r9,0
	setl r9b
	cmp r9b,1
	jz ___sha1..for_loop_2
	jnz ___sha1..for_after_2
___sha1..for_after_2:
	mov r10,qword [rsp+184]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,64
	idiv r10
	mov rdx,r11
	mov r10,rax
	mov qword [rsp+120],r10
	mov r10,qword [rsp+120]
	mov rsi,r10
	imul rsi,8
	mov r10,qword [rsp+56]
	add rsi,r10
	mov rsi,qword [rsi+8]
	mov r10,qword [rsp+184]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,64
	idiv r10
	mov r10,rdx
	mov qword [rsp+72],r10
	mov rdx,r11
	mov r10,qword [rsp+72]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,4
	idiv r10
	mov rdx,r11
	mov rbx,rax
	imul rbx,8
	add rbx,rsi
	mov rbx,qword [rbx+8]
	mov r10,qword [rsp+184]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,4
	idiv r10
	mov r10,rdx
	mov qword [rsp+32],r10
	mov rdx,r11
	mov rsi,3
	mov r10,qword [rsp+32]
	sub rsi,r10
	imul rsi,8
	mov r11,rcx
	mov rax,128
	mov rcx,rsi
	sal rax,cl
	mov r9,rax
	mov rcx,r11
	mov rsi,rbx
	or rsi,r9
	mov r10,qword [rsp+184]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,64
	idiv r10
	mov rdx,r11
	mov r10,rax
	mov qword [rsp],r10
	mov r10,qword [rsp]
	mov r9,r10
	imul r9,8
	mov r10,qword [rsp+56]
	add r9,r10
	mov r9,qword [r9+8]
	mov r10,qword [rsp+184]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,64
	idiv r10
	mov r13,rdx
	mov rdx,r11
	mov rax,r13
	mov r11,rdx
	cqo
	mov r10,4
	idiv r10
	mov rdx,r11
	mov rdi,rax
	imul rdi,8
	add rdi,r9
	mov qword [rdi+8],rsi
	mov r10,qword [rsp+168]
	mov r9,r10
	sal r9,3
	mov rsi,rcx
	sub rsi,1
	imul rsi,8
	mov r10,qword [rsp+56]
	add rsi,r10
	mov rsi,qword [rsi+8]
	add rsi,120
	mov qword [rsi+8],r9
	mov r10,qword [rsp+168]
	mov r9,r10
	sar r9,29
	and r9,7
	mov rsi,rcx
	sub rsi,1
	imul rsi,8
	mov r10,qword [rsp+56]
	add rsi,r10
	mov rsi,qword [rsi+8]
	add rsi,112
	mov qword [rsi+8],r9
	mov rdi,1732584193
	mov rsi,43913
	mov r9,61389
	sal r9,16
	or rsi,r9
	jmp ___sha1..lohi.entry
___sha1..lohi.entry:
	mov r10,rsi
	mov qword [rsp+96],r10
	mov r13,56574
	mov rsi,39098
	mov r9,rsi
	sal r9,16
	mov rsi,r13
	or rsi,r9
	jmp ___sha1..lohi.entry_2
___sha1..lohi.entry_2:
	mov r10,rsi
	mov qword [rsp+40],r10
	mov rsi,271733878
	mov r13,57840
	mov r9,50130
	sal r9,16
	or r13,r9
	jmp ___sha1..lohi.entry_3
___sha1..lohi.entry_3:
	mov r9,r13
	mov r10,r9
	mov qword [rsp+112],r10
	mov r10,0
	mov qword [rsp+184],r10
	jmp ___sha1..for_cond_3
___sha1..for_cond_3:
	mov r10,qword [rsp+184]
	cmp r10,rcx
	mov r9,0
	setl r9b
	cmp r9b,1
	jz ___sha1..for_loop_3
	jnz ___sha1..for_after_3
___sha1..for_loop_3:
	mov r10,16
	mov qword [rsp+176],r10
	jmp ___sha1..for_cond_4
___sha1..for_cond_4:
	mov r10,qword [rsp+176]
	cmp r10,80
	mov r9,0
	setl r9b
	cmp r9b,1
	jz ___sha1..for_loop_4
	jnz ___sha1..for_after_4
___sha1..for_after_4:
	mov rdx,rdi
	mov r10,qword [rsp+96]
	mov qword [rsp+64],r10
	mov r10,qword [rsp+40]
	mov r9,r10
	mov r10,rsi
	mov qword [rsp+104],r10
	mov r10,qword [rsp+112]
	mov r12,r10
	mov r10,0
	mov qword [rsp+176],r10
	jmp ___sha1..for_cond_5
___sha1..for_cond_5:
	mov r10,qword [rsp+176]
	cmp r10,80
	mov r13,0
	setl r13b
	cmp r13b,1
	jz ___sha1..for_loop_5
	jnz ___sha1..for_after_5
___sha1..for_loop_5:
	mov r15,0
	mov r14,0
	mov r10,qword [rsp+176]
	cmp r10,20
	mov r13,0
	setl r13b
	cmp r13b,1
	jz ___sha1..if_true_2
	jnz ___sha1..if_false
___sha1..if_false:
	mov r10,qword [rsp+176]
	cmp r10,40
	mov r13,0
	setl r13b
	cmp r13b,1
	jz ___sha1..if_true_3
	jnz ___sha1..if_false_2
___sha1..if_false_2:
	mov r10,qword [rsp+176]
	cmp r10,60
	mov r13,0
	setl r13b
	cmp r13b,1
	jz ___sha1..if_true_4
	jnz ___sha1..if_false_3
___sha1..if_false_3:
	mov r10,qword [rsp+64]
	mov r13,r10
	xor r13,r9
	mov r10,qword [rsp+104]
	xor r13,r10
	mov r15,r13
	mov r13,49622
	mov rbx,51810
	sal rbx,16
	or r13,rbx
	jmp ___sha1..lohi.entry_4
___sha1..lohi.entry_4:
	mov r14,r13
	jmp ___sha1..if_after_2
___sha1..if_true_4:
	mov r10,qword [rsp+64]
	mov r13,r10
	and r13,r9
	mov r10,qword [rsp+64]
	mov rbx,r10
	mov r10,qword [rsp+104]
	and rbx,r10
	or r13,rbx
	mov rbx,r9
	mov r10,qword [rsp+104]
	and rbx,r10
	mov r15,r13
	or r15,rbx
	mov r14,48348
	mov r13,36635
	sal r13,16
	or r14,r13
	jmp ___sha1..lohi.entry_5
___sha1..lohi.entry_5:
	jmp ___sha1..if_after_2
___sha1..if_after_2:
	jmp ___sha1..if_after_3
___sha1..if_true_3:
	mov r10,qword [rsp+64]
	mov r15,r10
	xor r15,r9
	mov r10,qword [rsp+104]
	xor r15,r10
	mov r14,1859775393
	jmp ___sha1..if_after_3
___sha1..if_after_3:
	jmp ___sha1..if_after_4
___sha1..if_true_2:
	mov r10,qword [rsp+64]
	mov r15,r10
	and r15,r9
	mov r10,qword [rsp+64]
	mov r13,r10
	not r13
	mov r10,qword [rsp+104]
	and r13,r10
	or r15,r13
	mov r14,1518500249
	jmp ___sha1..if_after_4
___sha1..if_after_4:
	mov r10,rdx
	mov qword [rsp+8],r10
	mov rbx,5
	cmp rbx,1
	mov r13,0
	sete r13b
	cmp r13b,1
	jz ___sha1..if_true_5
	jnz ___sha1..if_after_5
___sha1..if_after_5:
	cmp rbx,31
	mov r13,0
	sete r13b
	cmp r13b,1
	jz ___sha1..if_true_6
	jnz ___sha1..if_after_6
___sha1..if_true_6:
	mov r10,qword [rsp+8]
	mov r13,r10
	and r13,1
	mov rbx,r13
	sal rbx,31
	mov r10,qword [rsp+8]
	mov r13,r10
	sar r13,1
	and r13,2147483647
	or rbx,r13
	jmp ___sha1..rotate_left.exit
___sha1..if_after_6:
	mov r13,32
	sub r13,rbx
	mov r11,rcx
	mov rax,1
	mov rcx,r13
	sal rax,cl
	mov r13,rax
	mov rcx,r11
	sub r13,1
	mov r10,r13
	mov qword [rsp+136],r10
	mov r10,qword [rsp+8]
	mov r13,r10
	mov r10,qword [rsp+136]
	and r13,r10
	mov r11,rcx
	mov rax,r13
	mov rcx,rbx
	sal rax,cl
	mov r10,rax
	mov qword [rsp+24],r10
	mov rcx,r11
	mov r13,32
	sub r13,rbx
	mov r11,rcx
	mov r10,qword [rsp+8]
	mov rax,r10
	mov rcx,r13
	sar rax,cl
	mov r13,rax
	mov rcx,r11
	mov r11,rcx
	mov rax,1
	mov rcx,rbx
	sal rax,cl
	mov rbx,rax
	mov rcx,r11
	sub rbx,1
	and r13,rbx
	mov r10,qword [rsp+24]
	mov rbx,r10
	or rbx,r13
	jmp ___sha1..rotate_left.exit
___sha1..if_true_5:
	mov r10,qword [rsp+8]
	mov r13,r10
	and r13,2147483647
	sal r13,1
	mov r10,qword [rsp+8]
	mov rbx,r10
	sar rbx,31
	and rbx,1
	or r13,rbx
	mov rbx,r13
	jmp ___sha1..rotate_left.exit
___sha1..rotate_left.exit:
	mov r10,r12
	mov qword [rsp+48],r10
	mov r12,rbx
	and r12,65535
	mov r10,qword [rsp+48]
	mov r13,r10
	and r13,65535
	add r12,r13
	mov r13,rbx
	sar r13,16
	and r13,65535
	mov r10,qword [rsp+48]
	mov rbx,r10
	sar rbx,16
	and rbx,65535
	add r13,rbx
	mov rbx,r12
	sar rbx,16
	add r13,rbx
	and r13,65535
	sal r13,16
	mov rbx,r12
	and rbx,65535
	or r13,rbx
	jmp ___sha1..add.entry
___sha1..add.entry:
	mov r12,r13
	mov rbx,r15
	and rbx,65535
	mov r13,r14
	and r13,65535
	add rbx,r13
	sar r15,16
	mov r13,r15
	and r13,65535
	mov r15,r14
	sar r15,16
	and r15,65535
	add r13,r15
	mov r15,rbx
	sar r15,16
	add r13,r15
	and r13,65535
	sal r13,16
	and rbx,65535
	or r13,rbx
	jmp ___sha1..add.entry_2
___sha1..add.entry_2:
	mov rbx,r13
	mov r13,r12
	mov r14,rbx
	mov rbx,r13
	and rbx,65535
	mov r15,r14
	and r15,65535
	add rbx,r15
	sar r13,16
	mov r12,r13
	and r12,65535
	mov r13,r14
	sar r13,16
	mov r15,r13
	and r15,65535
	mov r13,r12
	add r13,r15
	mov r15,rbx
	sar r15,16
	add r13,r15
	and r13,65535
	sal r13,16
	and rbx,65535
	or r13,rbx
	jmp ___sha1..add.entry_3
___sha1..add.entry_3:
	mov rbx,r13
	mov r10,qword [rsp+184]
	mov r13,r10
	imul r13,8
	mov r10,qword [rsp+56]
	add r13,r10
	mov r13,qword [r13+8]
	mov r10,qword [rsp+176]
	mov r12,r10
	imul r12,8
	add r12,r13
	mov r12,qword [r12+8]
	mov r15,rbx
	and r15,65535
	mov r13,r12
	and r13,65535
	add r15,r13
	sar rbx,16
	and rbx,65535
	sar r12,16
	and r12,65535
	add rbx,r12
	mov r13,r15
	sar r13,16
	add rbx,r13
	and rbx,65535
	mov r13,rbx
	sal r13,16
	and r15,65535
	or r13,r15
	jmp ___sha1..add.entry_4
___sha1..add.entry_4:
	mov r14,r13
	mov r10,qword [rsp+104]
	mov r12,r10
	mov r10,r9
	mov qword [rsp+104],r10
	mov r10,qword [rsp+64]
	mov r9,r10
	mov rbx,30
	cmp rbx,1
	mov r13,0
	sete r13b
	cmp r13b,1
	jz ___sha1..if_true_7
	jnz ___sha1..if_after_7
___sha1..if_after_7:
	cmp rbx,31
	mov r13,0
	sete r13b
	cmp r13b,1
	jz ___sha1..if_true_8
	jnz ___sha1..if_after_8
___sha1..if_after_8:
	mov r13,32
	sub r13,rbx
	mov r11,rcx
	mov rax,1
	mov rcx,r13
	sal rax,cl
	mov r13,rax
	mov rcx,r11
	sub r13,1
	mov r15,r13
	mov r13,r9
	and r13,r15
	mov r11,rcx
	mov rax,r13
	mov rcx,rbx
	sal rax,cl
	mov r13,rax
	mov rcx,r11
	mov r15,32
	sub r15,rbx
	mov r11,rcx
	mov rax,r9
	mov rcx,r15
	sar rax,cl
	mov r15,rax
	mov rcx,r11
	mov r11,rcx
	mov rax,1
	mov rcx,rbx
	sal rax,cl
	mov r9,rax
	mov rcx,r11
	sub r9,1
	and r15,r9
	or r13,r15
	jmp ___sha1..rotate_left.exit_2
___sha1..if_true_8:
	mov r13,r9
	and r13,1
	sal r13,31
	sar r9,1
	and r9,2147483647
	or r13,r9
	jmp ___sha1..rotate_left.exit_2
___sha1..if_true_7:
	mov r13,r9
	and r13,2147483647
	sal r13,1
	sar r9,31
	and r9,1
	or r13,r9
	jmp ___sha1..rotate_left.exit_2
___sha1..rotate_left.exit_2:
	mov r9,r13
	mov r10,rdx
	mov qword [rsp+64],r10
	mov rdx,r14
	jmp ___sha1..for_step
___sha1..for_step:
	mov r10,qword [rsp+176]
	mov r13,r10
	mov r10,qword [rsp+176]
	add r10,1
	mov qword [rsp+176],r10
	jmp ___sha1..for_cond_5
___sha1..for_after_5:
	mov rbx,rdi
	and rbx,65535
	mov r13,rdx
	and r13,65535
	add rbx,r13
	mov r13,rdi
	sar r13,16
	and r13,65535
	sar rdx,16
	and rdx,65535
	add r13,rdx
	mov rdi,rbx
	sar rdi,16
	add r13,rdi
	and r13,65535
	sal r13,16
	and rbx,65535
	or r13,rbx
	jmp ___sha1..add.entry_5
___sha1..add.entry_5:
	mov rdi,r13
	mov r10,qword [rsp+96]
	mov rbx,r10
	mov r10,qword [rsp+64]
	mov r15,r10
	mov r13,rbx
	and r13,65535
	mov rdx,r15
	and rdx,65535
	add r13,rdx
	sar rbx,16
	mov rdx,rbx
	and rdx,65535
	sar r15,16
	mov rbx,r15
	and rbx,65535
	mov r15,rdx
	add r15,rbx
	mov rbx,r13
	sar rbx,16
	add r15,rbx
	mov rbx,r15
	and rbx,65535
	sal rbx,16
	and r13,65535
	or rbx,r13
	jmp ___sha1..add.entry_6
___sha1..add.entry_6:
	mov r10,rbx
	mov qword [rsp+96],r10
	mov r10,qword [rsp+40]
	mov r13,r10
	mov r15,r9
	mov r9,r13
	and r9,65535
	mov rbx,r15
	and rbx,65535
	add r9,rbx
	sar r13,16
	and r13,65535
	mov rbx,r15
	sar rbx,16
	and rbx,65535
	add r13,rbx
	mov rbx,r9
	sar rbx,16
	add r13,rbx
	and r13,65535
	sal r13,16
	and r9,65535
	or r13,r9
	jmp ___sha1..add.entry_7
___sha1..add.entry_7:
	mov r10,r13
	mov qword [rsp+40],r10
	mov r13,rsi
	mov r10,qword [rsp+104]
	mov rsi,r10
	mov r9,r13
	and r9,65535
	mov rbx,rsi
	and rbx,65535
	add r9,rbx
	sar r13,16
	and r13,65535
	sar rsi,16
	and rsi,65535
	add r13,rsi
	mov rsi,r9
	sar rsi,16
	add r13,rsi
	and r13,65535
	sal r13,16
	and r9,65535
	or r13,r9
	jmp ___sha1..add.entry_8
___sha1..add.entry_8:
	mov rsi,r13
	mov r10,qword [rsp+112]
	mov r13,r10
	mov r9,r13
	and r9,65535
	mov rbx,r12
	and rbx,65535
	add r9,rbx
	sar r13,16
	and r13,65535
	mov rbx,r12
	sar rbx,16
	and rbx,65535
	add r13,rbx
	mov rbx,r9
	sar rbx,16
	add r13,rbx
	and r13,65535
	sal r13,16
	and r9,65535
	or r13,r9
	jmp ___sha1..add.entry_9
___sha1..add.entry_9:
	mov r10,r13
	mov qword [rsp+112],r10
	jmp ___sha1..for_step_2
___sha1..for_step_2:
	mov r10,qword [rsp+184]
	mov r9,r10
	mov r10,qword [rsp+184]
	add r10,1
	mov qword [rsp+184],r10
	jmp ___sha1..for_cond_3
___sha1..for_loop_4:
	mov r10,qword [rsp+184]
	mov r9,r10
	imul r9,8
	mov r10,qword [rsp+56]
	add r9,r10
	mov r9,qword [r9+8]
	mov r10,qword [rsp+176]
	mov r13,r10
	sub r13,3
	mov rbx,r13
	imul rbx,8
	add rbx,r9
	mov rbx,qword [rbx+8]
	mov r10,qword [rsp+184]
	mov r13,r10
	imul r13,8
	mov r10,qword [rsp+56]
	add r13,r10
	mov r13,qword [r13+8]
	mov r10,qword [rsp+176]
	mov r9,r10
	sub r9,8
	imul r9,8
	add r9,r13
	mov r9,qword [r9+8]
	xor rbx,r9
	mov r10,qword [rsp+184]
	mov r9,r10
	imul r9,8
	mov r10,qword [rsp+56]
	add r9,r10
	mov r9,qword [r9+8]
	mov r10,qword [rsp+176]
	mov r13,r10
	sub r13,14
	imul r13,8
	add r13,r9
	mov r13,qword [r13+8]
	mov r9,rbx
	xor r9,r13
	mov r10,qword [rsp+184]
	mov rbx,r10
	imul rbx,8
	mov r10,qword [rsp+56]
	add rbx,r10
	mov rbx,qword [rbx+8]
	mov r10,qword [rsp+176]
	mov r13,r10
	sub r13,16
	imul r13,8
	add r13,rbx
	mov r13,qword [r13+8]
	xor r9,r13
	mov r15,r9
	mov rbx,1
	cmp rbx,1
	mov r9,0
	sete r9b
	cmp r9b,1
	jz ___sha1..if_true_9
	jnz ___sha1..if_after_9
___sha1..if_after_9:
	cmp rbx,31
	mov r9,0
	sete r9b
	cmp r9b,1
	jz ___sha1..if_true_10
	jnz ___sha1..if_after_10
___sha1..if_true_10:
	mov r9,r15
	and r9,1
	mov r13,r9
	sal r13,31
	mov r9,r15
	sar r9,1
	and r9,2147483647
	or r13,r9
	jmp ___sha1..rotate_left.exit_3
___sha1..if_after_10:
	mov r9,32
	sub r9,rbx
	mov r11,rcx
	mov rax,1
	mov rcx,r9
	sal rax,cl
	mov r9,rax
	mov rcx,r11
	sub r9,1
	mov r13,r15
	and r13,r9
	mov r11,rcx
	mov rax,r13
	mov rcx,rbx
	sal rax,cl
	mov r13,rax
	mov rcx,r11
	mov r9,32
	sub r9,rbx
	mov r11,rcx
	mov rax,r15
	mov rcx,r9
	sar rax,cl
	mov r9,rax
	mov rcx,r11
	mov r11,rcx
	mov rax,1
	mov rcx,rbx
	sal rax,cl
	mov rbx,rax
	mov rcx,r11
	sub rbx,1
	and r9,rbx
	or r13,r9
	jmp ___sha1..rotate_left.exit_3
___sha1..if_true_9:
	mov r9,r15
	and r9,2147483647
	sal r9,1
	sar r15,31
	and r15,1
	or r9,r15
	mov r13,r9
	jmp ___sha1..rotate_left.exit_3
___sha1..rotate_left.exit_3:
	mov r10,qword [rsp+184]
	mov r9,r10
	imul r9,8
	mov r10,qword [rsp+56]
	add r9,r10
	mov r9,qword [r9+8]
	mov r10,qword [rsp+176]
	mov rbx,r10
	imul rbx,8
	add rbx,r9
	mov qword [rbx+8],r13
	jmp ___sha1..for_step_3
___sha1..for_step_3:
	mov r10,qword [rsp+176]
	mov r9,r10
	mov r10,qword [rsp+176]
	add r10,1
	mov qword [rsp+176],r10
	jmp ___sha1..for_cond_4
___sha1..for_after_3:
	mov r9,r8
	add r9,0
	mov qword [r9+8],rdi
	mov r9,r8
	add r9,8
	mov r10,qword [rsp+96]
	mov qword [r9+8],r10
	mov r9,r8
	add r9,16
	mov r10,qword [rsp+40]
	mov qword [r9+8],r10
	mov r9,r8
	add r9,24
	mov qword [r9+8],rsi
	mov rsi,r8
	add rsi,32
	mov r10,qword [rsp+112]
	mov qword [rsi+8],r10
	jmp ___sha1..sha1.exit
___sha1..for_loop_2:
	mov r10,qword [rsp+184]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,64
	idiv r10
	mov rdx,r11
	mov rsi,rax
	mov r9,rsi
	imul r9,8
	mov r10,qword [rsp+56]
	add r9,r10
	mov r9,qword [r9+8]
	mov r10,qword [rsp+184]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,64
	idiv r10
	mov r10,rdx
	mov qword [rsp+16],r10
	mov rdx,r11
	mov r10,qword [rsp+16]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,4
	idiv r10
	mov rdx,r11
	mov r15,rax
	mov r10,r15
	mov qword [rsp+88],r10
	mov r10,qword [rsp+88]
	imul r10,8
	mov qword [rsp+88],r10
	mov r10,qword [rsp+88]
	add r10,r9
	mov qword [rsp+88],r10
	mov r10,qword [rsp+88]
	mov r10,qword [r10+8]
	mov qword [rsp+88],r10
	mov r10,qword [rsp+184]
	mov r14,r10
	imul r14,8
	mov r10,qword [rsp+80]
	add r14,r10
	mov r14,qword [r14+8]
	mov r10,qword [rsp+184]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,4
	idiv r10
	mov r10,rdx
	mov qword [rsp+144],r10
	mov rdx,r11
	mov r9,3
	mov r10,qword [rsp+144]
	sub r9,r10
	imul r9,8
	mov r11,rcx
	mov rax,r14
	mov rcx,r9
	sal rax,cl
	mov r9,rax
	mov rcx,r11
	mov r10,qword [rsp+88]
	mov qword [rsp+128],r10
	mov r10,qword [rsp+128]
	or r10,r9
	mov qword [rsp+128],r10
	mov r10,qword [rsp+184]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,64
	idiv r10
	mov rdx,r11
	mov rdx,rax
	mov r9,rdx
	imul r9,8
	mov r10,qword [rsp+56]
	add r9,r10
	mov r9,qword [r9+8]
	mov r10,qword [rsp+184]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,64
	idiv r10
	mov r10,rdx
	mov qword [rsp+152],r10
	mov rdx,r11
	mov r10,qword [rsp+152]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,4
	idiv r10
	mov rdx,r11
	mov r12,rax
	mov r14,r12
	imul r14,8
	add r14,r9
	mov r10,qword [rsp+128]
	mov qword [r14+8],r10
	jmp ___sha1..for_step_4
___sha1..for_step_4:
	mov r10,qword [rsp+184]
	mov r9,r10
	mov r10,qword [rsp+184]
	add r10,1
	mov qword [rsp+184],r10
	jmp ___sha1..for_cond_2
___sha1..for_loop:
	mov r10,0
	mov qword [rsp+176],r10
	jmp ___sha1..for_cond_6
___sha1..for_cond_6:
	mov r10,qword [rsp+176]
	cmp r10,80
	mov r9,0
	setl r9b
	cmp r9b,1
	jz ___sha1..for_loop_6
	jnz ___sha1..for_after_6
___sha1..for_loop_6:
	mov r10,qword [rsp+184]
	mov r14,r10
	imul r14,8
	mov r10,qword [rsp+56]
	add r14,r10
	mov r14,qword [r14+8]
	mov r10,qword [rsp+176]
	mov r9,r10
	imul r9,8
	add r9,r14
	mov qword [r9+8],0
	jmp ___sha1..for_step_5
___sha1..for_step_5:
	mov r10,qword [rsp+176]
	mov r9,r10
	mov r10,qword [rsp+176]
	add r10,1
	mov qword [rsp+176],r10
	jmp ___sha1..for_cond_6
___sha1..for_after_6:
	jmp ___sha1..for_step_6
___sha1..for_step_6:
	mov r10,qword [rsp+184]
	mov r9,r10
	mov r10,qword [rsp+184]
	add r10,1
	mov qword [rsp+184],r10
	jmp ___sha1..for_cond
___sha1..if_true:
	mov qword [rsp+192],r9
	mov qword [rsp+200],rsi
	mov qword [rsp+216],r8
	mov qword [rsp+224],rcx
	mov qword [rsp+240],rdi
	mov qword [rsp+256],rdx
	mov rdi,r14
	call _Z7printlnPc
	mov rdx,qword [rsp+256]
	mov rdi,qword [rsp+240]
	mov rcx,qword [rsp+224]
	mov r8,qword [rsp+216]
	mov rsi,qword [rsp+200]
	mov r9,qword [rsp+192]
	mov r8,0
	jmp ___sha1..sha1.exit
___sha1..sha1.exit:
	mov rax,r8
	leave
	ret

main:
main..main.entry:
	push rbp
	mov rbp,rsp
	sub rsp,224
	mov r12,qword [___MAXLENGTH]
	mov r10,qword [___chunks]
	mov qword [rsp+32],r10
	mov rsi,___string_2
	mov r10,qword [___asciiTable]
	mov qword [rsp+128],r10
	mov rcx,qword [___inputBuffer]
	mov r10,qword [___outputBuffer]
	mov qword [rsp+64],r10
	mov r10,___string_3
	mov qword [rsp+56],r10
	mov r13,qword [___MAXCHUNK]
	mov rdi,___string_4
	mov r10,___string_5
	mov qword [rsp+120],r10
	mov r10,rsi
	mov qword [rsp+128],r10
	mov r13,100
	mov rsi,r13
	sub rsi,1
	mov r12,rsi
	imul r12,64
	sub r12,16
	mov r8,r13
	imul r8,8
	add r8,8
	mov qword [rsp+136],rsi
	mov qword [rsp+144],r9
	mov qword [rsp+160],r8
	mov qword [rsp+168],rcx
	mov qword [rsp+176],rdi
	mov qword [rsp+200],rdx
	mov rdi,r8
	call malloc
	mov rdx,qword [rsp+200]
	mov rdi,qword [rsp+176]
	mov rcx,qword [rsp+168]
	mov r8,qword [rsp+160]
	mov r9,qword [rsp+144]
	mov rsi,qword [rsp+136]
	mov r8,rax
	mov qword [r8],r13
	mov r15,0
	jmp main..for_cond
main..for_cond:
	cmp r15,r13
	mov rsi,0
	setl sil
	cmp sil,1
	jz main..for_loop
	jnz main..for_after
main..for_after:
	mov r10,r8
	mov qword [rsp+32],r10
	mov rcx,r12
	imul rcx,8
	add rcx,8
	mov qword [rsp+136],rsi
	mov qword [rsp+144],r9
	mov qword [rsp+160],r8
	mov qword [rsp+168],rcx
	mov qword [rsp+176],rdi
	mov qword [rsp+200],rdx
	mov rdi,rcx
	call malloc
	mov rdx,qword [rsp+200]
	mov rdi,qword [rsp+176]
	mov rcx,qword [rsp+168]
	mov r8,qword [rsp+160]
	mov r9,qword [rsp+144]
	mov rsi,qword [rsp+136]
	mov rcx,rax
	mov qword [rcx],r12
	mov rsi,48
	mov qword [rsp+136],rsi
	mov qword [rsp+144],r9
	mov qword [rsp+160],r8
	mov qword [rsp+168],rcx
	mov qword [rsp+176],rdi
	mov qword [rsp+200],rdx
	mov rdi,rsi
	call malloc
	mov rdx,qword [rsp+200]
	mov rdi,qword [rsp+176]
	mov rcx,qword [rsp+168]
	mov r8,qword [rsp+160]
	mov r9,qword [rsp+144]
	mov rsi,qword [rsp+136]
	mov rsi,rax
	mov qword [rsi],5
	mov r10,rsi
	mov qword [rsp+64],r10
	mov rsi,0
	mov rsi,0
	jmp main..while_cond
main..while_cond:
	jmp main..while_loop
main..while_loop:
	mov qword [rsp+136],rsi
	mov qword [rsp+144],r9
	mov qword [rsp+160],r8
	mov qword [rsp+168],rcx
	mov qword [rsp+176],rdi
	mov qword [rsp+200],rdx
	call _Z6getIntv
	mov rdx,qword [rsp+200]
	mov rdi,qword [rsp+176]
	mov rcx,qword [rsp+168]
	mov r8,qword [rsp+160]
	mov r9,qword [rsp+144]
	mov rsi,qword [rsp+136]
	mov rsi,rax
	cmp rsi,0
	mov r8,0
	sete r8b
	cmp r8b,1
	jz main..if_true
	jnz main..if_after
main..if_true:
	jmp main..while_after
main..while_after:
	mov qword [___MAXLENGTH],r12
	mov r10,qword [rsp+32]
	mov qword [___chunks],r10
	mov r10,qword [rsp+128]
	mov qword [___asciiTable],r10
	mov qword [___inputBuffer],rcx
	mov r10,qword [rsp+64]
	mov qword [___outputBuffer],r10
	mov qword [___MAXCHUNK],r13
	mov rax,0
	leave
	ret
main..if_after:
	cmp rsi,1
	mov r8,0
	sete r8b
	cmp r8b,1
	jz main..if_true_2
	jnz main..if_false
main..if_true_2:
	mov qword [rsp+136],rsi
	mov qword [rsp+144],r9
	mov qword [rsp+160],r8
	mov qword [rsp+168],rcx
	mov qword [rsp+176],rdi
	mov qword [rsp+200],rdx
	call _Z9getStringv
	mov rdx,qword [rsp+200]
	mov rdi,qword [rsp+176]
	mov rcx,qword [rsp+168]
	mov r8,qword [rsp+160]
	mov r9,qword [rsp+144]
	mov rsi,qword [rsp+136]
	mov rsi,rax
	mov r8,rsi
	mov r10,0
	mov qword [rsp+88],r10
	mov r10,0
	mov qword [rsp+88],r10
	jmp main..for_cond_2
main..for_cond_2:
	mov rsi,qword [r8]
	mov r10,qword [rsp+88]
	cmp r10,rsi
	mov rsi,0
	setl sil
	cmp sil,1
	jz main..for_loop_2
	jnz main..for_after_2
main..for_loop_2:
	mov qword [rsp+136],rsi
	mov qword [rsp+144],r9
	mov qword [rsp+160],r8
	mov qword [rsp+168],rcx
	mov qword [rsp+176],rdi
	mov qword [rsp+200],rdx
	mov rsi,qword [rsp+88]
	mov rdi,qword [rsp+160]
	call _Z9stringOrdPci
	mov rdx,qword [rsp+200]
	mov rdi,qword [rsp+176]
	mov rcx,qword [rsp+168]
	mov r8,qword [rsp+160]
	mov r9,qword [rsp+144]
	mov rsi,qword [rsp+136]
	mov r15,rax
	mov r10,qword [rsp+88]
	mov rsi,r10
	imul rsi,8
	add rsi,rcx
	mov qword [rsi+8],r15
	jmp main..for_step
main..for_step:
	mov r10,qword [rsp+88]
	mov rsi,r10
	mov r10,qword [rsp+88]
	add r10,1
	mov qword [rsp+88],r10
	jmp main..for_cond_2
main..for_after_2:
	mov rsi,qword [r8]
	mov r10,qword [rsp+32]
	mov qword [___chunks],r10
	mov r10,qword [rsp+64]
	mov qword [___outputBuffer],r10
	mov qword [___MAXCHUNK],r13
	mov qword [rsp+136],rsi
	mov qword [rsp+144],r9
	mov qword [rsp+152],r13
	mov qword [rsp+160],r8
	mov qword [rsp+168],rcx
	mov qword [rsp+176],rdi
	mov qword [rsp+184],rbx
	mov qword [rsp+192],r15
	mov qword [rsp+200],rdx
	mov qword [rsp+208],r12
	mov qword [rsp+216],r14
	mov rsi,qword [rsp+136]
	mov rdi,qword [rsp+168]
	call ___sha1
	mov r14,qword [rsp+216]
	mov r12,qword [rsp+208]
	mov rdx,qword [rsp+200]
	mov r15,qword [rsp+192]
	mov rbx,qword [rsp+184]
	mov rdi,qword [rsp+176]
	mov rcx,qword [rsp+168]
	mov r8,qword [rsp+160]
	mov r13,qword [rsp+152]
	mov r9,qword [rsp+144]
	mov rsi,qword [rsp+136]
	mov rsi,rax
	mov r10,rsi
	mov qword [rsp+104],r10
	mov r10,0
	mov qword [rsp+88],r10
	jmp main..for_cond_3
main..for_cond_3:
	mov r10,qword [rsp+104]
	mov rsi,qword [r10]
	mov r10,qword [rsp+88]
	cmp r10,rsi
	mov rsi,0
	setl sil
	cmp sil,1
	jz main..for_loop_3
	jnz main..for_after_3
main..for_after_3:
	mov qword [rsp+136],rsi
	mov qword [rsp+144],r9
	mov qword [rsp+160],r8
	mov qword [rsp+168],rcx
	mov qword [rsp+176],rdi
	mov qword [rsp+200],rdx
	mov rdi,qword [rsp+176]
	call _Z7printlnPc
	mov rdx,qword [rsp+200]
	mov rdi,qword [rsp+176]
	mov rcx,qword [rsp+168]
	mov r8,qword [rsp+160]
	mov r9,qword [rsp+144]
	mov rsi,qword [rsp+136]
	jmp main..if_after_2
main..for_loop_3:
	mov r10,qword [rsp+88]
	mov r15,r10
	imul r15,8
	mov r10,qword [rsp+104]
	add r15,r10
	mov r15,qword [r15+8]
	mov r14,rdi
	mov r10,0
	mov qword [rsp+96],r10
	mov r10,28
	mov qword [rsp+96],r10
	jmp main..for_cond_4
main..for_cond_4:
	mov r10,qword [rsp+96]
	cmp r10,0
	mov rsi,0
	setge sil
	cmp sil,1
	jz main..for_loop_4
	jnz main..for_after_4
main..for_loop_4:
	mov r11,rcx
	mov rax,r15
	mov r10,qword [rsp+96]
	mov rcx,r10
	sar rax,cl
	mov rsi,rax
	mov rcx,r11
	and rsi,15
	cmp rsi,10
	mov r8,0
	setl r8b
	cmp r8b,1
	jz main..if_true_3
	jnz main..if_false_2
main..if_true_3:
	add rsi,48
	mov r8,rsi
	cmp r8,32
	mov rsi,0
	setge sil
	cmp sil,1
	jz main..lhs_true
	jnz main..lhs_false
main..lhs_true:
	cmp r8,126
	mov rsi,0
	setle sil
	jmp main..lhs_merge
main..lhs_false:
	mov rsi,0
	jmp main..lhs_merge
main..lhs_merge:
	cmp sil,1
	jz main..if_true_4
	jnz main..if_after_3
main..if_after_3:
	mov rsi,rdi
	jmp main..int2chr.exit
main..if_true_4:
	mov rsi,r8
	sub rsi,32
	sub r8,32
	mov qword [rsp+136],rsi
	mov qword [rsp+144],r9
	mov qword [rsp+160],r8
	mov qword [rsp+168],rcx
	mov qword [rsp+176],rdi
	mov qword [rsp+200],rdx
	mov rdx,qword [rsp+160]
	mov rsi,qword [rsp+136]
	mov rdi,qword [rsp+128]
	call _Z15stringSubStringPcii
	mov rdx,qword [rsp+200]
	mov rdi,qword [rsp+176]
	mov rcx,qword [rsp+168]
	mov r8,qword [rsp+160]
	mov r9,qword [rsp+144]
	mov rsi,qword [rsp+136]
	mov rsi,rax
	jmp main..int2chr.exit
main..int2chr.exit:
	mov qword [rsp+136],rsi
	mov qword [rsp+144],r9
	mov qword [rsp+160],r8
	mov qword [rsp+168],rcx
	mov qword [rsp+176],rdi
	mov qword [rsp+200],rdx
	mov rsi,qword [rsp+136]
	mov rdi,r14
	call _Z12stringConcatPcS_
	mov rdx,qword [rsp+200]
	mov rdi,qword [rsp+176]
	mov rcx,qword [rsp+168]
	mov r8,qword [rsp+160]
	mov r9,qword [rsp+144]
	mov rsi,qword [rsp+136]
	mov r14,rax
	jmp main..if_after_4
main..if_false_2:
	add rsi,65
	sub rsi,10
	mov r8,rsi
	cmp r8,32
	mov rsi,0
	setge sil
	cmp sil,1
	jz main..lhs_true_2
	jnz main..lhs_false_2
main..lhs_true_2:
	cmp r8,126
	mov rsi,0
	setle sil
	jmp main..lhs_merge_2
main..lhs_false_2:
	mov rsi,0
	jmp main..lhs_merge_2
main..lhs_merge_2:
	cmp sil,1
	jz main..if_true_5
	jnz main..if_after_5
main..if_after_5:
	mov rsi,rdi
	jmp main..int2chr.exit_2
main..if_true_5:
	mov rsi,r8
	sub rsi,32
	sub r8,32
	mov qword [rsp+136],rsi
	mov qword [rsp+144],r9
	mov qword [rsp+160],r8
	mov qword [rsp+168],rcx
	mov qword [rsp+176],rdi
	mov qword [rsp+200],rdx
	mov rdx,qword [rsp+160]
	mov rsi,qword [rsp+136]
	mov rdi,qword [rsp+128]
	call _Z15stringSubStringPcii
	mov rdx,qword [rsp+200]
	mov rdi,qword [rsp+176]
	mov rcx,qword [rsp+168]
	mov r8,qword [rsp+160]
	mov r9,qword [rsp+144]
	mov rsi,qword [rsp+136]
	mov rsi,rax
	jmp main..int2chr.exit_2
main..int2chr.exit_2:
	mov qword [rsp+136],rsi
	mov qword [rsp+144],r9
	mov qword [rsp+160],r8
	mov qword [rsp+168],rcx
	mov qword [rsp+176],rdi
	mov qword [rsp+200],rdx
	mov rsi,qword [rsp+136]
	mov rdi,r14
	call _Z12stringConcatPcS_
	mov rdx,qword [rsp+200]
	mov rdi,qword [rsp+176]
	mov rcx,qword [rsp+168]
	mov r8,qword [rsp+160]
	mov r9,qword [rsp+144]
	mov rsi,qword [rsp+136]
	mov r14,rax
	jmp main..if_after_4
main..if_after_4:
	jmp main..for_step_2
main..for_step_2:
	mov r10,qword [rsp+96]
	mov rsi,r10
	sub rsi,4
	mov r10,rsi
	mov qword [rsp+96],r10
	jmp main..for_cond_4
main..for_after_4:
	mov qword [rsp+136],rsi
	mov qword [rsp+144],r9
	mov qword [rsp+160],r8
	mov qword [rsp+168],rcx
	mov qword [rsp+176],rdi
	mov qword [rsp+200],rdx
	mov rdi,r14
	call _Z5printPc
	mov rdx,qword [rsp+200]
	mov rdi,qword [rsp+176]
	mov rcx,qword [rsp+168]
	mov r8,qword [rsp+160]
	mov r9,qword [rsp+144]
	mov rsi,qword [rsp+136]
	jmp main..for_step_3
main..for_step_3:
	mov r10,qword [rsp+88]
	mov rsi,r10
	mov r10,qword [rsp+88]
	add r10,1
	mov qword [rsp+88],r10
	jmp main..for_cond_3
main..if_false:
	cmp rsi,2
	mov rsi,0
	sete sil
	cmp sil,1
	jz main..if_true_6
	jnz main..if_after_6
main..if_true_6:
	mov qword [rsp+136],rsi
	mov qword [rsp+144],r9
	mov qword [rsp+160],r8
	mov qword [rsp+168],rcx
	mov qword [rsp+176],rdi
	mov qword [rsp+200],rdx
	call _Z9getStringv
	mov rdx,qword [rsp+200]
	mov rdi,qword [rsp+176]
	mov rcx,qword [rsp+168]
	mov r8,qword [rsp+160]
	mov r9,qword [rsp+144]
	mov rsi,qword [rsp+136]
	mov rsi,rax
	mov r10,rsi
	mov qword [rsp+8],r10
	mov rsi,48
	mov qword [rsp+136],rsi
	mov qword [rsp+144],r9
	mov qword [rsp+160],r8
	mov qword [rsp+168],rcx
	mov qword [rsp+176],rdi
	mov qword [rsp+200],rdx
	mov rdi,rsi
	call malloc
	mov rdx,qword [rsp+200]
	mov rdi,qword [rsp+176]
	mov rcx,qword [rsp+168]
	mov r8,qword [rsp+160]
	mov r9,qword [rsp+144]
	mov rsi,qword [rsp+136]
	mov rsi,rax
	mov qword [rsi],5
	mov r10,rsi
	mov qword [rsp+80],r10
	mov r10,qword [rsp+8]
	mov rsi,qword [r10]
	cmp rsi,40
	mov rsi,0
	setne sil
	cmp sil,1
	jz main..if_true_7
	jnz main..if_after_7
main..if_true_7:
	mov qword [rsp+136],rsi
	mov qword [rsp+144],r9
	mov qword [rsp+160],r8
	mov qword [rsp+168],rcx
	mov qword [rsp+176],rdi
	mov qword [rsp+200],rdx
	mov rdi,qword [rsp+56]
	call _Z7printlnPc
	mov rdx,qword [rsp+200]
	mov rdi,qword [rsp+176]
	mov rcx,qword [rsp+168]
	mov r8,qword [rsp+160]
	mov r9,qword [rsp+144]
	mov rsi,qword [rsp+136]
	jmp main..crackSHA1.exit
main..if_after_7:
	mov r10,0
	mov qword [rsp+72],r10
	mov r10,0
	mov qword [rsp+72],r10
	jmp main..for_cond_5
main..for_cond_5:
	mov r10,qword [rsp+72]
	cmp r10,5
	mov rsi,0
	setl sil
	cmp sil,1
	jz main..for_loop_5
	jnz main..for_after_5
main..for_loop_5:
	mov r10,qword [rsp+72]
	mov rsi,r10
	imul rsi,8
	mov r10,qword [rsp+80]
	add rsi,r10
	mov qword [rsi+8],0
	jmp main..for_step_4
main..for_step_4:
	mov r10,qword [rsp+72]
	mov rsi,r10
	mov r10,qword [rsp+72]
	add r10,1
	mov qword [rsp+72],r10
	jmp main..for_cond_5
main..for_after_5:
	mov r10,0
	mov qword [rsp+72],r10
	jmp main..for_cond_6
main..for_cond_6:
	mov r10,qword [rsp+72]
	cmp r10,40
	mov rsi,0
	setl sil
	cmp sil,1
	jz main..for_loop_6
	jnz main..for_after_6
main..for_loop_6:
	mov r10,qword [rsp+72]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,8
	idiv r10
	mov rdx,r11
	mov r10,rax
	mov qword [rsp+16],r10
	mov r10,qword [rsp+16]
	mov r8,r10
	imul r8,8
	mov r10,qword [rsp+80]
	add r8,r10
	mov r8,qword [r8+8]
	mov r10,qword [rsp+72]
	mov rsi,r10
	add rsi,3
	mov qword [rsp+136],rsi
	mov qword [rsp+144],r9
	mov qword [rsp+160],r8
	mov qword [rsp+168],rcx
	mov qword [rsp+176],rdi
	mov qword [rsp+200],rdx
	mov rdx,qword [rsp+136]
	mov rsi,qword [rsp+72]
	mov rdi,qword [rsp+8]
	call _Z15stringSubStringPcii
	mov rdx,qword [rsp+200]
	mov rdi,qword [rsp+176]
	mov rcx,qword [rsp+168]
	mov r8,qword [rsp+160]
	mov r9,qword [rsp+144]
	mov rsi,qword [rsp+136]
	mov rsi,rax
	mov r10,rsi
	mov qword [rsp],r10
	mov r10,0
	mov qword [rsp+40],r10
	mov r14,0
	mov r10,0
	mov qword [rsp+40],r10
	jmp main..for_cond_7
main..for_cond_7:
	mov r10,qword [rsp]
	mov rsi,qword [r10]
	mov r10,qword [rsp+40]
	cmp r10,rsi
	mov rsi,0
	setl sil
	cmp sil,1
	jz main..for_loop_7
	jnz main..for_after_7
main..for_loop_7:
	mov qword [rsp+136],rsi
	mov qword [rsp+144],r9
	mov qword [rsp+160],r8
	mov qword [rsp+168],rcx
	mov qword [rsp+176],rdi
	mov qword [rsp+200],rdx
	mov rsi,qword [rsp+40]
	mov rdi,qword [rsp]
	call _Z9stringOrdPci
	mov rdx,qword [rsp+200]
	mov rdi,qword [rsp+176]
	mov rcx,qword [rsp+168]
	mov r8,qword [rsp+160]
	mov r9,qword [rsp+144]
	mov rsi,qword [rsp+136]
	mov r15,rax
	cmp r15,48
	mov rsi,0
	setge sil
	cmp sil,1
	jz main..lhs_true_3
	jnz main..lhs_false_3
main..lhs_false_3:
	mov rsi,0
	jmp main..lhs_merge_3
main..lhs_true_3:
	cmp r15,57
	mov rsi,0
	setle sil
	jmp main..lhs_merge_3
main..lhs_merge_3:
	cmp sil,1
	jz main..if_true_8
	jnz main..if_false_3
main..if_true_8:
	imul r14,16
	mov rsi,r14
	add rsi,r15
	mov r14,rsi
	sub r14,48
	jmp main..if_after_8
main..if_false_3:
	cmp r15,65
	mov rsi,0
	setge sil
	cmp sil,1
	jz main..lhs_true_4
	jnz main..lhs_false_4
main..lhs_true_4:
	cmp r15,70
	mov rsi,0
	setle sil
	jmp main..lhs_merge_4
main..lhs_false_4:
	mov rsi,0
	jmp main..lhs_merge_4
main..lhs_merge_4:
	cmp sil,1
	jz main..if_true_9
	jnz main..if_false_4
main..if_false_4:
	cmp r15,97
	mov rsi,0
	setge sil
	cmp sil,1
	jz main..lhs_true_5
	jnz main..lhs_false_5
main..lhs_true_5:
	cmp r15,102
	mov rsi,0
	setle sil
	jmp main..lhs_merge_5
main..lhs_false_5:
	mov rsi,0
	jmp main..lhs_merge_5
main..lhs_merge_5:
	cmp sil,1
	jz main..if_true_10
	jnz main..if_false_5
main..if_true_10:
	imul r14,16
	add r14,r15
	sub r14,97
	add r14,10
	jmp main..if_after_9
main..if_after_9:
	jmp main..if_after_10
main..if_false_5:
	mov r15,0
	jmp main..hex2int.exit
main..if_true_9:
	imul r14,16
	mov rsi,r14
	add rsi,r15
	sub rsi,65
	mov r14,rsi
	add r14,10
	jmp main..if_after_10
main..if_after_10:
	jmp main..if_after_8
main..if_after_8:
	jmp main..for_step_5
main..for_step_5:
	mov r10,qword [rsp+40]
	mov rsi,r10
	mov r10,qword [rsp+40]
	add r10,1
	mov qword [rsp+40],r10
	jmp main..for_cond_7
main..for_after_7:
	mov r15,r14
	jmp main..hex2int.exit
main..hex2int.exit:
	mov r10,qword [rsp+72]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,4
	idiv r10
	mov rdx,r11
	mov rdx,rax
	mov rax,rdx
	mov r11,rdx
	cqo
	mov r10,2
	idiv r10
	mov r9,rdx
	mov rdx,r11
	mov rsi,1
	sub rsi,r9
	imul rsi,16
	mov r11,rcx
	mov rax,r15
	mov rcx,rsi
	sal rax,cl
	mov rsi,rax
	mov rcx,r11
	or r8,rsi
	mov r10,qword [rsp+72]
	mov rax,r10
	mov r11,rdx
	cqo
	mov r10,8
	idiv r10
	mov rdx,r11
	mov rbx,rax
	mov rsi,rbx
	imul rsi,8
	mov r10,qword [rsp+80]
	add rsi,r10
	mov qword [rsi+8],r8
	jmp main..for_step_6
main..for_step_6:
	mov r10,qword [rsp+72]
	mov rsi,r10
	add rsi,4
	mov r10,rsi
	mov qword [rsp+72],r10
	jmp main..for_cond_6
main..for_after_6:
	mov r10,4
	mov qword [rsp+112],r10
	mov r10,0
	mov qword [rsp+24],r10
	mov r10,1
	mov qword [rsp+24],r10
	jmp main..for_cond_8
main..for_cond_8:
	mov r10,qword [rsp+24]
	mov r11,qword [rsp+112]
	cmp r10,r11
	mov rsi,0
	setle sil
	cmp sil,1
	jz main..for_loop_8
	jnz main..for_after_8
main..for_after_8:
	mov qword [rsp+136],rsi
	mov qword [rsp+144],r9
	mov qword [rsp+160],r8
	mov qword [rsp+168],rcx
	mov qword [rsp+176],rdi
	mov qword [rsp+200],rdx
	mov rdi,qword [rsp+120]
	call _Z7printlnPc
	mov rdx,qword [rsp+200]
	mov rdi,qword [rsp+176]
	mov rcx,qword [rsp+168]
	mov r8,qword [rsp+160]
	mov r9,qword [rsp+144]
	mov rsi,qword [rsp+136]
	jmp main..crackSHA1.exit
main..for_loop_8:
	mov r10,0
	mov qword [rsp+72],r10
	jmp main..for_cond_9
main..for_cond_9:
	mov r10,qword [rsp+72]
	mov r11,qword [rsp+24]
	cmp r10,r11
	mov rsi,0
	setl sil
	cmp sil,1
	jz main..for_loop_9
	jnz main..for_after_9
main..for_loop_9:
	mov r10,qword [rsp+72]
	mov rsi,r10
	imul rsi,8
	add rsi,rcx
	mov qword [rsi+8],48
	jmp main..for_step_7
main..for_step_7:
	mov r10,qword [rsp+72]
	mov rsi,r10
	mov r10,qword [rsp+72]
	add r10,1
	mov qword [rsp+72],r10
	jmp main..for_cond_9
main..for_after_9:
	jmp main..while_cond_2
main..while_cond_2:
	jmp main..while_loop_2
main..while_loop_2:
	mov r10,qword [rsp+32]
	mov qword [___chunks],r10
	mov r10,qword [rsp+64]
	mov qword [___outputBuffer],r10
	mov qword [___MAXCHUNK],r13
	mov qword [rsp+136],rsi
	mov qword [rsp+144],r9
	mov qword [rsp+152],r13
	mov qword [rsp+160],r8
	mov qword [rsp+168],rcx
	mov qword [rsp+176],rdi
	mov qword [rsp+184],rbx
	mov qword [rsp+192],r15
	mov qword [rsp+200],rdx
	mov qword [rsp+208],r12
	mov qword [rsp+216],r14
	mov rsi,qword [rsp+24]
	mov rdi,qword [rsp+168]
	call ___sha1
	mov r14,qword [rsp+216]
	mov r12,qword [rsp+208]
	mov rdx,qword [rsp+200]
	mov r15,qword [rsp+192]
	mov rbx,qword [rsp+184]
	mov rdi,qword [rsp+176]
	mov rcx,qword [rsp+168]
	mov r8,qword [rsp+160]
	mov r13,qword [rsp+152]
	mov r9,qword [rsp+144]
	mov rsi,qword [rsp+136]
	mov r15,rax
	mov r10,qword [rsp+80]
	mov r14,r10
	mov rsi,qword [r15]
	mov r8,qword [r14]
	cmp rsi,r8
	mov rsi,0
	setne sil
	cmp sil,1
	jz main..if_true_11
	jnz main..if_after_11
main..if_true_11:
	mov rsi,0
	jmp main..array_equal.exit
main..if_after_11:
	mov rsi,0
	mov rsi,0
	jmp main..for_cond_10
main..for_cond_10:
	mov r8,qword [r15]
	cmp rsi,r8
	mov r8,0
	setl r8b
	cmp r8b,1
	jz main..for_loop_10
	jnz main..for_after_10
main..for_loop_10:
	mov r10,rsi
	mov qword [rsp+48],r10
	mov r10,qword [rsp+48]
	imul r10,8
	mov qword [rsp+48],r10
	mov r10,qword [rsp+48]
	add r10,r15
	mov qword [rsp+48],r10
	mov r10,qword [rsp+48]
	mov r10,qword [r10+8]
	mov qword [rsp+48],r10
	mov r8,rsi
	imul r8,8
	add r8,r14
	mov r8,qword [r8+8]
	mov r10,qword [rsp+48]
	cmp r10,r8
	mov r8,0
	setne r8b
	cmp r8b,1
	jz main..if_true_12
	jnz main..if_after_12
main..if_after_12:
	jmp main..for_step_8
main..for_step_8:
	mov r8,rsi
	add rsi,1
	jmp main..for_cond_10
main..if_true_12:
	mov rsi,0
	jmp main..array_equal.exit
main..for_after_10:
	mov rsi,1
	jmp main..array_equal.exit
main..array_equal.exit:
	cmp sil,1
	jz main..if_true_13
	jnz main..if_after_13
main..if_after_13:
	mov r15,rcx
	mov r10,qword [rsp+24]
	mov rsi,r10
	mov r8,0
	sub rsi,1
	mov r8,rsi
	jmp main..for_cond_11
main..for_cond_11:
	cmp r8,0
	mov rsi,0
	setge sil
	cmp sil,1
	jz main..for_loop_11
	jnz main..for_after_11
main..for_loop_11:
	mov rsi,r8
	imul rsi,8
	add rsi,r15
	mov rsi,qword [rsi+8]
	mov r14,rsi
	cmp r14,122
	mov rsi,0
	sete sil
	cmp sil,1
	jz main..if_true_14
	jnz main..if_after_14
main..if_true_14:
	mov rsi,-1
	jmp main..nextLetter.exit
main..if_after_14:
	cmp r14,90
	mov rsi,0
	sete sil
	cmp sil,1
	jz main..if_true_15
	jnz main..if_after_15
main..if_after_15:
	cmp r14,57
	mov rsi,0
	sete sil
	cmp sil,1
	jz main..if_true_16
	jnz main..if_after_16
main..if_after_16:
	mov rsi,r14
	add rsi,1
	jmp main..nextLetter.exit
main..if_true_16:
	mov rsi,65
	jmp main..nextLetter.exit
main..if_true_15:
	mov rsi,97
	jmp main..nextLetter.exit
main..nextLetter.exit:
	mov r14,r8
	imul r14,8
	add r14,r15
	mov qword [r14+8],rsi
	mov rsi,r8
	imul rsi,8
	add rsi,r15
	mov rsi,qword [rsi+8]
	mov r14,-1
	cmp rsi,r14
	mov rsi,0
	sete sil
	cmp sil,1
	jz main..if_true_17
	jnz main..if_false_6
main..if_false_6:
	mov rsi,1
	jmp main..nextText.exit
main..if_true_17:
	mov rsi,r8
	imul rsi,8
	add rsi,r15
	mov qword [rsi+8],48
	jmp main..if_after_17
main..if_after_17:
	jmp main..for_step_9
main..for_step_9:
	mov rsi,r8
	sub r8,1
	jmp main..for_cond_11
main..for_after_11:
	mov rsi,0
	jmp main..nextText.exit
main..nextText.exit:
	xor rsi,1
	cmp sil,1
	jz main..if_true_18
	jnz main..if_after_18
main..if_after_18:
	jmp main..while_cond_2
main..if_true_18:
	jmp main..while_after_2
main..while_after_2:
	jmp main..for_step_10
main..for_step_10:
	mov r10,qword [rsp+24]
	mov rsi,r10
	mov r10,qword [rsp+24]
	add r10,1
	mov qword [rsp+24],r10
	jmp main..for_cond_8
main..if_true_13:
	mov r10,0
	mov qword [rsp+72],r10
	jmp main..for_cond_12
main..for_cond_12:
	mov r10,qword [rsp+72]
	mov r11,qword [rsp+24]
	cmp r10,r11
	mov rsi,0
	setl sil
	cmp sil,1
	jz main..for_loop_12
	jnz main..for_after_12
main..for_after_12:
	mov qword [rsp+136],rsi
	mov qword [rsp+144],r9
	mov qword [rsp+160],r8
	mov qword [rsp+168],rcx
	mov qword [rsp+176],rdi
	mov qword [rsp+200],rdx
	mov rdi,qword [rsp+176]
	call _Z7printlnPc
	mov rdx,qword [rsp+200]
	mov rdi,qword [rsp+176]
	mov rcx,qword [rsp+168]
	mov r8,qword [rsp+160]
	mov r9,qword [rsp+144]
	mov rsi,qword [rsp+136]
	jmp main..crackSHA1.exit
main..crackSHA1.exit:
	jmp main..if_after_6
main..for_loop_12:
	mov r10,qword [rsp+72]
	mov rsi,r10
	imul rsi,8
	add rsi,rcx
	mov rsi,qword [rsi+8]
	mov r15,rsi
	cmp r15,32
	mov rsi,0
	setge sil
	cmp sil,1
	jz main..lhs_true_6
	jnz main..lhs_false_6
main..lhs_true_6:
	cmp r15,126
	mov rsi,0
	setle sil
	jmp main..lhs_merge_6
main..lhs_false_6:
	mov rsi,0
	jmp main..lhs_merge_6
main..lhs_merge_6:
	cmp sil,1
	jz main..if_true_19
	jnz main..if_after_19
main..if_true_19:
	mov r8,r15
	sub r8,32
	mov rsi,r15
	sub rsi,32
	mov qword [rsp+136],rsi
	mov qword [rsp+144],r9
	mov qword [rsp+160],r8
	mov qword [rsp+168],rcx
	mov qword [rsp+176],rdi
	mov qword [rsp+200],rdx
	mov rdx,qword [rsp+136]
	mov rsi,qword [rsp+160]
	mov rdi,qword [rsp+128]
	call _Z15stringSubStringPcii
	mov rdx,qword [rsp+200]
	mov rdi,qword [rsp+176]
	mov rcx,qword [rsp+168]
	mov r8,qword [rsp+160]
	mov r9,qword [rsp+144]
	mov rsi,qword [rsp+136]
	mov rsi,rax
	jmp main..int2chr.exit_3
main..if_after_19:
	mov rsi,rdi
	jmp main..int2chr.exit_3
main..int2chr.exit_3:
	mov qword [rsp+136],rsi
	mov qword [rsp+144],r9
	mov qword [rsp+160],r8
	mov qword [rsp+168],rcx
	mov qword [rsp+176],rdi
	mov qword [rsp+200],rdx
	mov rdi,qword [rsp+136]
	call _Z5printPc
	mov rdx,qword [rsp+200]
	mov rdi,qword [rsp+176]
	mov rcx,qword [rsp+168]
	mov r8,qword [rsp+160]
	mov r9,qword [rsp+144]
	mov rsi,qword [rsp+136]
	jmp main..for_step_11
main..for_step_11:
	mov r10,qword [rsp+72]
	mov rsi,r10
	mov r10,qword [rsp+72]
	add r10,1
	mov qword [rsp+72],r10
	jmp main..for_cond_12
main..if_after_6:
	jmp main..if_after_2
main..if_after_2:
	jmp main..while_cond
main..for_loop:
	mov rcx,648
	mov qword [rsp+136],rsi
	mov qword [rsp+144],r9
	mov qword [rsp+160],r8
	mov qword [rsp+168],rcx
	mov qword [rsp+176],rdi
	mov qword [rsp+200],rdx
	mov rdi,rcx
	call malloc
	mov rdx,qword [rsp+200]
	mov rdi,qword [rsp+176]
	mov rcx,qword [rsp+168]
	mov r8,qword [rsp+160]
	mov r9,qword [rsp+144]
	mov rsi,qword [rsp+136]
	mov rcx,rax
	mov qword [rcx],80
	mov rsi,r15
	imul rsi,8
	add rsi,r8
	mov qword [rsi+8],rcx
	jmp main..for_step_12
main..for_step_12:
	add r15,1
	jmp main..for_cond

section .data
___string_2:
	db 95,0,0,0,0,0,0,0,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,0
___string_4:
	db 0,0,0,0,0,0,0,0,0
___string:
	db 18,0,0,0,0,0,0,0,110,67,104,117,110,107,32,62,32,77,65,88,67,72,85,78,75,33,0
___string_3:
	db 13,0,0,0,0,0,0,0,73,110,118,97,108,105,100,32,105,110,112,117,116,0
___string_5:
	db 10,0,0,0,0,0,0,0,78,111,116,32,70,111,117,110,100,33,0

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


