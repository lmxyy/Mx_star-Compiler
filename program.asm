global main

extern malloc
section .text

___getResult:
___getResult..getResult.entry:
	push rbp
	mov rbp,rsp
	sub rsp,96
	mov qword [rsp],rdi
	mov qword [rsp+16],rsi
	mov qword [rsp+8],rdx
	mov r9,qword [rsp]
	mov rcx,qword [rsp+16]
	mov rbx,qword [rsp+8]
	mov rsi,qword [___gps]
	mov rdi,qword [___prime]
	mov r13,qword [___result]
	mov rdx,qword [___b]
	mov r12,rcx
	imul r12,8
	add r12,r13
	mov r12,qword [r12+8]
	mov r15,rbx
	imul r15,8
	add r15,r12
	mov r15,qword [r15+8]
	mov r12,-1
	cmp r15,r12
	mov r12,0
	sete r12b
	cmp r12b,1
	jz ___getResult..if_true
	jnz ___getResult..if_after
___getResult..if_true:
	mov r12,rbx
	imul r12,8
	add r12,rdi
	mov r12,qword [r12+8]
	imul r12,2
	mov r15,rcx
	imul r15,8
	add r15,rdi
	mov r15,qword [r15+8]
	sub r12,r15
	cmp r12,r9
	mov r12,0
	setle r12b
	cmp r12b,1
	jz ___getResult..if_true_2
	jnz ___getResult..if_after_2
___getResult..if_true_2:
	mov r15,rbx
	imul r15,8
	add r15,rdi
	mov r15,qword [r15+8]
	imul r15,2
	mov r12,rcx
	imul r12,8
	add r12,rdi
	mov r12,qword [r12+8]
	sub r15,r12
	mov r12,r15
	imul r12,8
	add r12,rdx
	mov r12,qword [r12+8]
	cmp r12,0
	mov r12,0
	setne r12b
	cmp r12b,1
	jz ___getResult..if_true_3
	jnz ___getResult..if_after_3
___getResult..if_true_3:
	mov r12,rbx
	imul r12,8
	add r12,rdi
	mov r12,qword [r12+8]
	imul r12,2
	mov rdx,rcx
	imul rdx,8
	add rdx,rdi
	mov rdx,qword [rdx+8]
	sub r12,rdx
	imul r12,8
	add r12,rsi
	mov r12,qword [r12+8]
	mov qword [rsp+24],r12
	mov qword [rsp+32],rsi
	mov qword [rsp+40],r13
	mov qword [rsp+48],rdx
	mov qword [rsp+56],rcx
	mov qword [rsp+64],rbx
	mov qword [rsp+72],r9
	mov qword [rsp+80],rdi
	mov qword [rsp+88],r15
	mov rdx,r12
	mov rsi,rbx
	mov rdi,qword [rsp+72]
	call ___getResult
	mov r15,qword [rsp+88]
	mov rdi,qword [rsp+80]
	mov r9,qword [rsp+72]
	mov rbx,qword [rsp+64]
	mov rcx,qword [rsp+56]
	mov rdx,qword [rsp+48]
	mov r13,qword [rsp+40]
	mov rsi,qword [rsp+32]
	mov r12,qword [rsp+24]
	mov r12,rax
	mov rsi,r12
	add rsi,1
	mov rdx,rcx
	imul rdx,8
	add rdx,r13
	mov rdx,qword [rdx+8]
	mov r12,rbx
	imul r12,8
	add r12,rdx
	mov qword [r12+8],rsi
	jmp ___getResult..if_after_3
___getResult..if_after_3:
	jmp ___getResult..if_after_2
___getResult..if_after_2:
	jmp ___getResult..if_after
___getResult..if_after:
	mov r12,rcx
	imul r12,8
	add r12,r13
	mov r12,qword [r12+8]
	mov rsi,rbx
	imul rsi,8
	add rsi,r12
	mov rsi,qword [rsi+8]
	mov r12,-1
	cmp rsi,r12
	mov r12,0
	sete r12b
	cmp r12b,1
	jz ___getResult..if_true_4
	jnz ___getResult..if_after_4
___getResult..if_true_4:
	mov r12,rcx
	imul r12,8
	add r12,r13
	mov r12,qword [r12+8]
	mov rsi,rbx
	imul rsi,8
	add rsi,r12
	mov qword [rsi+8],1
	jmp ___getResult..if_after_4
___getResult..if_after_4:
	imul rcx,8
	add rcx,r13
	mov rcx,qword [rcx+8]
	imul rbx,8
	add rbx,rcx
	mov rbx,qword [rbx+8]
	mov rax,rbx
	leave
	ret

main:
main..main.entry:
	push rbp
	mov rbp,rsp
	sub rsp,160
	mov r9,qword [___resultCount]
	mov r15,qword [___prime]
	mov r10,___string
	mov qword [rsp+16],r10
	mov r10,___string_2
	mov qword [rsp+40],r10
	mov rdx,___string_3
	mov r10,qword [___M]
	mov qword [rsp+8],r10
	mov r8,qword [___primeCount]
	mov r10,qword [___j]
	mov qword [rsp+24],r10
	mov r10,qword [___b]
	mov qword [rsp],r10
	mov r13,qword [___tmp]
	mov r14,qword [___gps]
	mov r10,qword [___N]
	mov qword [rsp+48],r10
	mov rsi,qword [___result]
	mov rcx,qword [___i]
	mov r10,0
	mov qword [rsp+48],r10
	mov r10,0
	mov qword [rsp+8],r10
	mov rcx,0
	mov r10,0
	mov qword [rsp+24],r10
	mov r8,0
	mov r9,0
	mov r12,8016
	mov qword [rsp+80],rsi
	mov qword [rsp+88],rdx
	mov qword [rsp+104],rcx
	mov qword [rsp+120],r9
	mov qword [rsp+136],rdi
	mov qword [rsp+152],r8
	mov rdi,r12
	call malloc
	mov r8,qword [rsp+152]
	mov rdi,qword [rsp+136]
	mov r9,qword [rsp+120]
	mov rcx,qword [rsp+104]
	mov rdx,qword [rsp+88]
	mov rsi,qword [rsp+80]
	mov r12,rax
	mov qword [r12],1001
	mov r10,r12
	mov qword [rsp],r10
	mov r15,1368
	mov qword [rsp+80],rsi
	mov qword [rsp+88],rdx
	mov qword [rsp+104],rcx
	mov qword [rsp+120],r9
	mov qword [rsp+136],rdi
	mov qword [rsp+152],r8
	mov rdi,r15
	call malloc
	mov r8,qword [rsp+152]
	mov rdi,qword [rsp+136]
	mov r9,qword [rsp+120]
	mov rcx,qword [rsp+104]
	mov rdx,qword [rsp+88]
	mov rsi,qword [rsp+80]
	mov r15,rax
	mov qword [r15],170
	mov r14,8016
	mov qword [rsp+80],rsi
	mov qword [rsp+88],rdx
	mov qword [rsp+104],rcx
	mov qword [rsp+120],r9
	mov qword [rsp+136],rdi
	mov qword [rsp+152],r8
	mov rdi,r14
	call malloc
	mov r8,qword [rsp+152]
	mov rdi,qword [rsp+136]
	mov r9,qword [rsp+120]
	mov rcx,qword [rsp+104]
	mov rdx,qword [rsp+88]
	mov rsi,qword [rsp+80]
	mov r14,rax
	mov qword [r14],1001
	mov r13,16
	mov qword [rsp+80],rsi
	mov qword [rsp+88],rdx
	mov qword [rsp+104],rcx
	mov qword [rsp+120],r9
	mov qword [rsp+136],rdi
	mov qword [rsp+152],r8
	mov rdi,r13
	call malloc
	mov r8,qword [rsp+152]
	mov rdi,qword [rsp+136]
	mov r9,qword [rsp+120]
	mov rcx,qword [rsp+104]
	mov rdx,qword [rsp+88]
	mov rsi,qword [rsp+80]
	mov r13,rax
	mov qword [r13],1
	mov rsi,0
	jmp main.._init.entry
main.._init.entry:
	mov r9,170
	mov rsi,r9
	imul rsi,8
	add rsi,8
	mov qword [rsp+80],rsi
	mov qword [rsp+88],rdx
	mov qword [rsp+104],rcx
	mov qword [rsp+120],r9
	mov qword [rsp+136],rdi
	mov qword [rsp+152],r8
	mov rdi,rsi
	call malloc
	mov r8,qword [rsp+152]
	mov rdi,qword [rsp+136]
	mov r9,qword [rsp+120]
	mov rcx,qword [rsp+104]
	mov rdx,qword [rsp+88]
	mov rsi,qword [rsp+80]
	mov rsi,rax
	mov qword [rsi],r9
	mov rcx,0
	jmp main..for_cond
main..for_cond:
	cmp rcx,r9
	mov r12,0
	setl r12b
	cmp r12b,1
	jz main..for_loop
	jnz main..for_after
main..for_after:
	mov r10,1000
	mov qword [rsp+48],r10
	mov qword [rsp+80],rsi
	mov qword [rsp+88],rdx
	mov qword [rsp+104],rcx
	mov qword [rsp+120],r9
	mov qword [rsp+136],rdi
	mov qword [rsp+152],r8
	call _Z6getIntv
	mov r8,qword [rsp+152]
	mov rdi,qword [rsp+136]
	mov r9,qword [rsp+120]
	mov rcx,qword [rsp+104]
	mov rdx,qword [rsp+88]
	mov rsi,qword [rsp+80]
	mov r12,rax
	mov r10,r12
	mov qword [rsp+8],r10
	mov r8,0
	mov r9,0
	mov r12,r13
	add r12,0
	mov qword [r12+8],0
	mov rcx,0
	jmp main..for_cond_2
main..for_cond_2:
	mov r10,qword [rsp+48]
	mov r12,r10
	add r12,1
	cmp rcx,r12
	mov r12,0
	setl r12b
	cmp r12b,1
	jz main..for_loop_2
	jnz main..for_after_2
main..for_loop_2:
	mov r12,rcx
	imul r12,8
	mov r10,qword [rsp]
	add r12,r10
	mov qword [r12+8],1
	mov r12,rcx
	imul r12,8
	add r12,r14
	mov qword [r12+8],0
	jmp main..for_step
main..for_step:
	add rcx,1
	jmp main..for_cond_2
main..for_after_2:
	mov rcx,0
	jmp main..for_cond_3
main..for_cond_3:
	mov r10,qword [rsp+8]
	mov r12,r10
	add r12,1
	cmp rcx,r12
	mov r12,0
	setl r12b
	cmp r12b,1
	jz main..for_loop_3
	jnz main..for_after_3
main..for_loop_3:
	mov r12,rcx
	imul r12,8
	add r12,r15
	mov qword [r12+8],0
	jmp main..for_step_2
main..for_step_2:
	add rcx,1
	jmp main..for_cond_3
main..for_after_3:
	mov rcx,0
	jmp main..for_cond_4
main..for_cond_4:
	mov r10,qword [rsp+8]
	cmp rcx,r10
	mov r12,0
	setle r12b
	cmp r12b,1
	jz main..for_loop_4
	jnz main..for_after_4
main..for_loop_4:
	mov r10,0
	mov qword [rsp+24],r10
	jmp main..for_cond_5
main..for_cond_5:
	mov r10,qword [rsp+24]
	mov r11,qword [rsp+8]
	cmp r10,r11
	mov r12,0
	setle r12b
	cmp r12b,1
	jz main..for_loop_5
	jnz main..for_after_5
main..for_loop_5:
	mov rbx,-1
	mov r12,rcx
	imul r12,8
	add r12,rsi
	mov r12,qword [r12+8]
	mov r10,qword [rsp+24]
	mov rdi,r10
	imul rdi,8
	add rdi,r12
	mov qword [rdi+8],rbx
	jmp main..for_step_3
main..for_step_3:
	mov r10,qword [rsp+24]
	mov r12,r10
	add r12,1
	mov r10,r12
	mov qword [rsp+24],r10
	jmp main..for_cond_5
main..for_after_5:
	jmp main..for_step_4
main..for_step_4:
	add rcx,1
	jmp main..for_cond_4
main..for_after_4:
	mov r10,qword [rsp+48]
	mov r8,r10
	mov rcx,2
	mov rbx,2
	jmp main..for_cond_6
main..for_cond_6:
	cmp rbx,r8
	mov r12,0
	setle r12b
	cmp r12b,1
	jz main..for_loop_6
	jnz main..for_after_6
main..for_after_6:
	mov r8,r13
	add r8,0
	mov r8,qword [r8+8]
	mov rcx,1
	jmp main..for_cond_7
main..for_cond_7:
	cmp rcx,r8
	mov r12,0
	setl r12b
	cmp r12b,1
	jz main..for_loop_7
	jnz main..for_after_7
main..for_loop_7:
	mov r12,rcx
	add r12,1
	mov r10,r12
	mov qword [rsp+24],r10
	jmp main..for_cond_8
main..for_cond_8:
	mov r10,qword [rsp+24]
	cmp r10,r8
	mov r12,0
	setle r12b
	cmp r12b,1
	jz main..for_loop_8
	jnz main..for_after_8
main..for_loop_8:
	mov rbx,rcx
	imul rbx,8
	add rbx,rsi
	mov rbx,qword [rbx+8]
	mov r10,qword [rsp+24]
	mov r12,r10
	imul r12,8
	add r12,rbx
	mov r12,qword [r12+8]
	mov rbx,-1
	cmp r12,rbx
	mov r12,0
	sete r12b
	cmp r12b,1
	jz main..if_true
	jnz main..if_after
main..if_true:
	mov qword [___gps],r14
	mov qword [___prime],r15
	mov qword [___result],rsi
	mov r10,qword [rsp]
	mov qword [___b],r10
	mov qword [rsp+72],r12
	mov qword [rsp+80],rsi
	mov qword [rsp+88],rdx
	mov qword [rsp+96],r13
	mov qword [rsp+104],rcx
	mov qword [rsp+112],rbx
	mov qword [rsp+120],r9
	mov qword [rsp+128],r15
	mov qword [rsp+136],rdi
	mov rdx,qword [rsp+24]
	mov rsi,qword [rsp+104]
	mov rdi,qword [rsp+48]
	call ___getResult
	mov rdi,qword [rsp+136]
	mov r15,qword [rsp+128]
	mov r9,qword [rsp+120]
	mov rbx,qword [rsp+112]
	mov rcx,qword [rsp+104]
	mov r13,qword [rsp+96]
	mov rdx,qword [rsp+88]
	mov rsi,qword [rsp+80]
	mov r12,qword [rsp+72]
	mov r12,rax
	mov rdi,rcx
	imul rdi,8
	add rdi,rsi
	mov rdi,qword [rdi+8]
	mov r10,qword [rsp+24]
	mov rbx,r10
	imul rbx,8
	add rbx,rdi
	mov qword [rbx+8],r12
	mov rbx,rcx
	imul rbx,8
	add rbx,rsi
	mov rbx,qword [rbx+8]
	mov r10,qword [rsp+24]
	mov r12,r10
	imul r12,8
	add r12,rbx
	mov r12,qword [r12+8]
	cmp r12,1
	mov r12,0
	setg r12b
	cmp r12b,1
	jz main..if_true_2
	jnz main..if_after_2
main..if_true_2:
	mov r10,rcx
	mov qword [rsp+56],r10
	mov r10,qword [rsp+56]
	imul r10,8
	mov qword [rsp+56],r10
	mov r10,qword [rsp+56]
	add r10,r15
	mov qword [rsp+56],r10
	mov r10,qword [rsp+56]
	mov r10,qword [r10+8]
	mov qword [rsp+56],r10
	mov r10,qword [rsp+24]
	mov rbx,r10
	imul rbx,8
	add rbx,r15
	mov rbx,qword [rbx+8]
	mov r12,rcx
	imul r12,8
	add r12,rsi
	mov r12,qword [r12+8]
	mov r10,qword [rsp+24]
	mov rdi,r10
	imul rdi,8
	add rdi,r12
	mov rdi,qword [rdi+8]
	mov r10,qword [rsp+56]
	mov r12,r10
	mov qword [rsp+80],rsi
	mov qword [rsp+88],rdx
	mov qword [rsp+104],rcx
	mov qword [rsp+120],r9
	mov qword [rsp+136],rdi
	mov qword [rsp+152],r8
	mov rdi,r12
	call _Z8printInti
	mov r8,qword [rsp+152]
	mov rdi,qword [rsp+136]
	mov r9,qword [rsp+120]
	mov rcx,qword [rsp+104]
	mov rdx,qword [rsp+88]
	mov rsi,qword [rsp+80]
	jmp main..while_cond
main..while_cond:
	cmp rdi,0
	mov r10,0
	setg r10b
	mov qword [rsp+64],r10
	mov r10,qword [rsp+64]
	cmp r10b,1
	jz main..while_loop
	jnz main..while_after
main..while_after:
	mov qword [rsp+80],rsi
	mov qword [rsp+88],rdx
	mov qword [rsp+104],rcx
	mov qword [rsp+120],r9
	mov qword [rsp+136],rdi
	mov qword [rsp+152],r8
	mov rdi,qword [rsp+16]
	call _Z5printPc
	mov r8,qword [rsp+152]
	mov rdi,qword [rsp+136]
	mov r9,qword [rsp+120]
	mov rcx,qword [rsp+104]
	mov rdx,qword [rsp+88]
	mov rsi,qword [rsp+80]
	add r9,1
	jmp main..if_after_2
main..if_after_2:
	jmp main..if_after
main..if_after:
	jmp main..for_step_5
main..for_step_5:
	mov r10,qword [rsp+24]
	mov r12,r10
	add r12,1
	mov r10,r12
	mov qword [rsp+24],r10
	jmp main..for_cond_8
main..while_loop:
	mov qword [rsp+80],rsi
	mov qword [rsp+88],rdx
	mov qword [rsp+104],rcx
	mov qword [rsp+120],r9
	mov qword [rsp+136],rdi
	mov qword [rsp+152],r8
	mov rdi,qword [rsp+40]
	call _Z5printPc
	mov r8,qword [rsp+152]
	mov rdi,qword [rsp+136]
	mov r9,qword [rsp+120]
	mov rcx,qword [rsp+104]
	mov rdx,qword [rsp+88]
	mov rsi,qword [rsp+80]
	mov qword [rsp+80],rsi
	mov qword [rsp+88],rdx
	mov qword [rsp+104],rcx
	mov qword [rsp+120],r9
	mov qword [rsp+136],rdi
	mov qword [rsp+152],r8
	mov rdi,rbx
	call _Z8printInti
	mov r8,qword [rsp+152]
	mov rdi,qword [rsp+136]
	mov r9,qword [rsp+120]
	mov rcx,qword [rsp+104]
	mov rdx,qword [rsp+88]
	mov rsi,qword [rsp+80]
	imul rbx,2
	sub rbx,r12
	add r12,rbx
	mov rax,r12
	mov r11,rdx
	cqo
	mov r10,2
	idiv r10
	mov rdx,r11
	mov r10,rax
	mov qword [rsp+32],r10
	mov r10,qword [rsp+32]
	mov r12,r10
	sub rdi,1
	jmp main..while_cond
main..for_after_8:
	jmp main..for_step_6
main..for_step_6:
	add rcx,1
	jmp main..for_cond_7
main..for_after_7:
	mov qword [rsp+80],rsi
	mov qword [rsp+88],rdx
	mov qword [rsp+104],rcx
	mov qword [rsp+120],r9
	mov qword [rsp+136],rdi
	mov qword [rsp+152],r8
	mov rdi,qword [rsp+88]
	call _Z5printPc
	mov r8,qword [rsp+152]
	mov rdi,qword [rsp+136]
	mov r9,qword [rsp+120]
	mov rcx,qword [rsp+104]
	mov rdx,qword [rsp+88]
	mov rsi,qword [rsp+80]
	mov qword [rsp+80],rsi
	mov qword [rsp+88],rdx
	mov qword [rsp+104],rcx
	mov qword [rsp+120],r9
	mov qword [rsp+136],rdi
	mov qword [rsp+152],r8
	mov rdi,qword [rsp+120]
	call _Z10printlnInti
	mov r8,qword [rsp+152]
	mov rdi,qword [rsp+136]
	mov r9,qword [rsp+120]
	mov rcx,qword [rsp+104]
	mov rdx,qword [rsp+88]
	mov rsi,qword [rsp+80]
	mov qword [___gps],r14
	mov qword [___resultCount],r9
	mov qword [___prime],r15
	mov r10,qword [rsp+48]
	mov qword [___N],r10
	mov qword [___result],rsi
	mov qword [___i],rcx
	mov r10,qword [rsp+8]
	mov qword [___M],r10
	mov qword [___primeCount],r8
	mov r10,qword [rsp+24]
	mov qword [___j],r10
	mov r10,qword [rsp]
	mov qword [___b],r10
	mov qword [___tmp],r13
	mov rax,0
	leave
	ret
main..for_loop_6:
	mov r12,rbx
	imul r12,8
	mov r10,qword [rsp]
	add r12,r10
	mov r12,qword [r12+8]
	cmp r12,1
	mov r12,0
	sete r12b
	cmp r12b,1
	jz main..if_true_3
	jnz main..if_after_3
main..if_true_3:
	mov r12,r13
	add r12,0
	mov r12,qword [r12+8]
	mov rdi,r12
	add rdi,1
	mov r12,r13
	add r12,0
	mov qword [r12+8],rdi
	mov r12,r13
	add r12,0
	mov r12,qword [r12+8]
	imul r12,8
	add r12,r15
	mov qword [r12+8],rbx
	mov rdi,r13
	add rdi,0
	mov rdi,qword [rdi+8]
	mov r12,rbx
	imul r12,8
	add r12,r14
	mov qword [r12+8],rdi
	jmp main..if_after_3
main..if_after_3:
	jmp main..while_cond_2
main..while_cond_2:
	mov r12,rbx
	imul r12,rcx
	cmp r12,r8
	mov r12,0
	setle r12b
	cmp r12b,1
	jz main..while_loop_2
	jnz main..while_after_2
main..while_loop_2:
	mov r12,rbx
	imul r12,rcx
	imul r12,8
	mov r10,qword [rsp]
	add r12,r10
	mov qword [r12+8],0
	add rcx,1
	jmp main..while_cond_2
main..while_after_2:
	mov rcx,2
	jmp main..for_step_7
main..for_step_7:
	add rbx,1
	jmp main..for_cond_6
main..for_loop:
	mov rbx,r9
	imul rbx,8
	add rbx,8
	mov qword [rsp+80],rsi
	mov qword [rsp+88],rdx
	mov qword [rsp+104],rcx
	mov qword [rsp+120],r9
	mov qword [rsp+136],rdi
	mov qword [rsp+152],r8
	mov rdi,rbx
	call malloc
	mov r8,qword [rsp+152]
	mov rdi,qword [rsp+136]
	mov r9,qword [rsp+120]
	mov rcx,qword [rsp+104]
	mov rdx,qword [rsp+88]
	mov rsi,qword [rsp+80]
	mov rbx,rax
	mov qword [rbx],r9
	mov r12,rcx
	imul r12,8
	add r12,rsi
	mov qword [r12+8],rbx
	mov r10,0
	mov qword [rsp+24],r10
	jmp main..for_cond_9
main..for_cond_9:
	mov r10,qword [rsp+24]
	cmp r10,r9
	mov r12,0
	setl r12b
	cmp r12b,1
	jz main..for_loop_9
	jnz main..for_after_9
main..for_after_9:
	jmp main..for_step_8
main..for_step_8:
	add rcx,1
	jmp main..for_cond
main..for_loop_9:
	mov rbx,rcx
	imul rbx,8
	add rbx,rsi
	mov rbx,qword [rbx+8]
	mov r10,qword [rsp+24]
	mov r12,r10
	imul r12,8
	add r12,rbx
	mov qword [r12+8],0
	jmp main..for_step_9
main..for_step_9:
	mov r10,qword [rsp+24]
	add r10,1
	mov qword [rsp+24],r10
	jmp main..for_cond_9

section .data
___string_2:
	db 1,0,0,0,0,0,0,0,32,0
___string:
	db 1,0,0,0,0,0,0,0,10,0
___string_3:
	db 7,0,0,0,0,0,0,0,84,111,116,97,108,58,32,0

section .bss
___N:
	resb 64
___M:
	resb 64
___i:
	resb 64
___j:
	resb 64
___primeCount:
	resb 64
___resultCount:
	resb 64
___b:
	resb 64
___prime:
	resb 64
___gps:
	resb 64
___tmp:
	resb 64
___result:
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


