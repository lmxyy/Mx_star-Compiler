global main

extern malloc
section .text

___random:
___random..random.entry:
	push rbp
	mov rbp,rsp
	sub rsp,64
	mov rdx,qword [___R]
	mov rsi,qword [___seed]
	mov r12,qword [___M]
	mov r8,qword [___Q]
	mov r15,qword [___A]
	mov rax,rsi
	mov r11,rdx
	cqo
	idiv r8
	mov rcx,rdx
	mov rdx,r11
	imul r15,rcx
	mov rax,rsi
	mov r11,rdx
	cqo
	idiv r8
	mov rdx,r11
	mov rdi,rax
	mov r8,rdx
	imul r8,rdi
	mov rsi,r15
	sub rsi,r8
	mov r8,rsi
	mov rsi,r8
	cmp rsi,0
	mov r8,0
	setge r8b
	cmp r8b,1
	jz ___random..if_true
	jnz ___random..if_false
___random..if_false:
	mov r8,rsi
	add r8,r12
	mov rsi,r8
	jmp ___random..if_after
___random..if_true:
	mov rsi,rsi
	jmp ___random..if_after
___random..if_after:
	mov qword [___seed],rsi
	mov rax,rsi
	leave
	ret

___initialize:
___initialize..initialize.entry:
	push rbp
	mov rbp,rsp
	sub rsp,16
	mov r8,qword [___seed]
	mov r8,rdi
	mov qword [___seed],r8
	leave
	ret

___swap:
___swap..swap.entry:
	push rbp
	mov rbp,rsp
	sub rsp,48
	mov rcx,qword [___a]
	mov r12,rdi
	imul r12,8
	add r12,rcx
	mov r12,qword [r12+8]
	mov r8,rsi
	imul r8,8
	add r8,rcx
	mov r8,qword [r8+8]
	imul rdi,8
	add rdi,rcx
	mov qword [rdi+8],r8
	mov r8,rsi
	imul r8,8
	add r8,rcx
	mov qword [r8+8],r12
	leave
	ret

___pd:
___pd..pd.entry:
	push rbp
	mov rbp,rsp
	sub rsp,48
	mov r8,qword [___h]
	jmp ___pd..for_cond
___pd..for_cond:
	cmp r8,rdi
	mov rsi,0
	setle sil
	cmp sil,1
	jz ___pd..for_loop
	jnz ___pd..for_after
___pd..for_loop:
	mov rsi,r8
	add rsi,1
	mov rcx,r8
	imul rcx,rsi
	mov rax,rcx
	cqo
	mov r10,2
	idiv r10
	mov r12,rax
	cmp rdi,r12
	mov rsi,0
	sete sil
	cmp sil,1
	jz ___pd..if_true
	jnz ___pd..if_after
___pd..if_true:
	mov rsi,1
	jmp ___pd..pd.exit
___pd..if_after:
	jmp ___pd..for_step
___pd..for_step:
	add r8,1
	jmp ___pd..for_cond
___pd..for_after:
	mov rsi,0
	jmp ___pd..pd.exit
___pd..pd.exit:
	mov qword [___h],r8
	mov rax,rsi
	leave
	ret

___show:
___show..show.entry:
	push rbp
	mov rbp,rsp
	sub rsp,48
	mov r12,qword [___a]
	mov rcx,qword [___now]
	mov rdi,___string
	mov rsi,___string_2
	mov rdx,0
	mov rdx,0
	jmp ___show..for_cond
___show..for_cond:
	cmp rdx,rcx
	mov r8,0
	setl r8b
	cmp r8b,1
	jz ___show..for_loop
	jnz ___show..for_after
___show..for_after:
	mov qword [rsp],r8
	mov qword [rsp+8],rdi
	mov qword [rsp+16],rsi
	mov qword [rsp+32],rcx
	mov qword [rsp+40],rdx
	mov rdi,qword [rsp+16]
	call _Z7printlnPc
	mov rdx,qword [rsp+40]
	mov rcx,qword [rsp+32]
	mov rsi,qword [rsp+16]
	mov rdi,qword [rsp+8]
	mov r8,qword [rsp]
	leave
	ret
___show..for_loop:
	mov r8,rdx
	imul r8,8
	add r8,r12
	mov r8,qword [r8+8]
	mov qword [rsp],r8
	mov qword [rsp+8],rdi
	mov qword [rsp+16],rsi
	mov qword [rsp+32],rcx
	mov qword [rsp+40],rdx
	mov rdi,qword [rsp]
	call _Z8printInti
	mov rdx,qword [rsp+40]
	mov rcx,qword [rsp+32]
	mov rsi,qword [rsp+16]
	mov rdi,qword [rsp+8]
	mov r8,qword [rsp]
	mov qword [rsp],r8
	mov qword [rsp+8],rdi
	mov qword [rsp+16],rsi
	mov qword [rsp+32],rcx
	mov qword [rsp+40],rdx
	mov rdi,qword [rsp+8]
	call _Z5printPc
	mov rdx,qword [rsp+40]
	mov rcx,qword [rsp+32]
	mov rsi,qword [rsp+16]
	mov rdi,qword [rsp+8]
	mov r8,qword [rsp]
	jmp ___show..for_step
___show..for_step:
	add rdx,1
	jmp ___show..for_cond

___win:
___win..win.entry:
	push rbp
	mov rbp,rsp
	sub rsp,64
	mov rsi,qword [___h]
	mov r12,qword [___a]
	mov r8,qword [___now]
	mov rdi,0
	mov rdx,0
	mov rcx,808
	mov qword [rsp],r8
	mov qword [rsp+8],rsi
	mov qword [rsp+16],rdi
	mov qword [rsp+32],rcx
	mov qword [rsp+40],rdx
	mov rdi,rcx
	call malloc
	mov rdx,qword [rsp+40]
	mov rcx,qword [rsp+32]
	mov rdi,qword [rsp+16]
	mov rsi,qword [rsp+8]
	mov r8,qword [rsp]
	mov rcx,rax
	mov qword [rcx],100
	mov r15,0
	cmp r8,rsi
	mov rsi,0
	setne sil
	cmp sil,1
	jz ___win..if_true
	jnz ___win..if_after
___win..if_after:
	mov rdx,0
	jmp ___win..for_cond
___win..for_cond:
	cmp rdx,r8
	mov rsi,0
	setl sil
	cmp sil,1
	jz ___win..for_loop
	jnz ___win..for_after
___win..for_after:
	mov rdi,0
	jmp ___win..for_cond_2
___win..for_cond_2:
	mov rsi,r8
	sub rsi,1
	cmp rdi,rsi
	mov rsi,0
	setl sil
	cmp sil,1
	jz ___win..for_loop_2
	jnz ___win..for_after_2
___win..for_loop_2:
	mov rdx,rdi
	add rdx,1
	jmp ___win..for_cond_3
___win..for_cond_3:
	cmp rdx,r8
	mov rsi,0
	setl sil
	cmp sil,1
	jz ___win..for_loop_3
	jnz ___win..for_after_3
___win..for_after_3:
	jmp ___win..for_step
___win..for_step:
	add rdi,1
	jmp ___win..for_cond_2
___win..for_loop_3:
	mov r12,rdi
	imul r12,8
	add r12,rcx
	mov r12,qword [r12+8]
	mov rsi,rdx
	imul rsi,8
	add rsi,rcx
	mov rsi,qword [rsi+8]
	cmp r12,rsi
	mov rsi,0
	setg sil
	cmp sil,1
	jz ___win..if_true_2
	jnz ___win..if_after_2
___win..if_true_2:
	mov r15,rdi
	imul r15,8
	add r15,rcx
	mov r15,qword [r15+8]
	mov r12,rdx
	imul r12,8
	add r12,rcx
	mov r12,qword [r12+8]
	mov rsi,rdi
	imul rsi,8
	add rsi,rcx
	mov qword [rsi+8],r12
	mov rsi,rdx
	imul rsi,8
	add rsi,rcx
	mov qword [rsi+8],r15
	jmp ___win..if_after_2
___win..if_after_2:
	jmp ___win..for_step_2
___win..for_step_2:
	add rdx,1
	jmp ___win..for_cond_3
___win..for_after_2:
	mov rdi,0
	jmp ___win..for_cond_4
___win..for_cond_4:
	cmp rdi,r8
	mov rsi,0
	setl sil
	cmp sil,1
	jz ___win..for_loop_4
	jnz ___win..for_after_4
___win..for_loop_4:
	mov r12,rdi
	imul r12,8
	add r12,rcx
	mov r12,qword [r12+8]
	mov rsi,rdi
	add rsi,1
	cmp r12,rsi
	mov rsi,0
	setne sil
	cmp sil,1
	jz ___win..if_true_3
	jnz ___win..if_after_3
___win..if_true_3:
	mov r8,0
	jmp ___win..win.exit
___win..if_after_3:
	jmp ___win..for_step_3
___win..for_step_3:
	add rdi,1
	jmp ___win..for_cond_4
___win..for_after_4:
	mov r8,1
	jmp ___win..win.exit
___win..for_loop:
	mov rsi,rdx
	imul rsi,8
	add rsi,r12
	mov rsi,qword [rsi+8]
	mov rdi,rdx
	imul rdi,8
	add rdi,rcx
	mov qword [rdi+8],rsi
	jmp ___win..for_step_4
___win..for_step_4:
	add rdx,1
	jmp ___win..for_cond
___win..if_true:
	mov r8,0
	jmp ___win..win.exit
___win..win.exit:
	mov rax,r8
	leave
	ret

___merge:
___merge..merge.entry:
	push rbp
	mov rbp,rsp
	sub rsp,48
	mov r12,qword [___a]
	mov rsi,qword [___now]
	mov rcx,0
	mov rcx,0
	jmp ___merge..for_cond
___merge..for_cond:
	cmp rcx,rsi
	mov r8,0
	setl r8b
	cmp r8b,1
	jz ___merge..for_loop
	jnz ___merge..for_after
___merge..for_after:
	mov rcx,0
	jmp ___merge..for_cond_2
___merge..for_cond_2:
	cmp rcx,rsi
	mov r8,0
	setl r8b
	cmp r8b,1
	jz ___merge..for_loop_2
	jnz ___merge..for_after_2
___merge..for_loop_2:
	mov r8,rcx
	imul r8,8
	add r8,r12
	mov r8,qword [r8+8]
	cmp r8,0
	mov r8,0
	sete r8b
	cmp r8b,1
	jz ___merge..if_true
	jnz ___merge..if_after
___merge..if_true:
	mov rsi,rcx
	jmp ___merge..for_after_2
___merge..if_after:
	jmp ___merge..for_step
___merge..for_step:
	add rcx,1
	jmp ___merge..for_cond_2
___merge..for_after_2:
	mov qword [___now],rsi
	leave
	ret
___merge..for_loop:
	mov r8,rcx
	imul r8,8
	add r8,r12
	mov r8,qword [r8+8]
	cmp r8,0
	mov r8,0
	sete r8b
	cmp r8b,1
	jz ___merge..if_true_2
	jnz ___merge..if_after_2
___merge..if_true_2:
	mov r8,0
	mov r8,rcx
	add r8,1
	jmp ___merge..for_cond_3
___merge..for_cond_3:
	cmp r8,rsi
	mov rdi,0
	setl dil
	cmp dil,1
	jz ___merge..for_loop_3
	jnz ___merge..for_after_3
___merge..for_loop_3:
	mov rdi,r8
	imul rdi,8
	add rdi,r12
	mov rdi,qword [rdi+8]
	cmp rdi,0
	mov rdi,0
	setne dil
	cmp dil,1
	jz ___merge..if_true_3
	jnz ___merge..if_after_3
___merge..if_true_3:
	mov qword [rsp],r8
	mov qword [rsp+8],rsi
	mov qword [rsp+16],rdi
	mov qword [rsp+24],r12
	mov qword [rsp+32],rcx
	mov rsi,qword [rsp]
	mov rdi,qword [rsp+32]
	call ___swap
	mov rcx,qword [rsp+32]
	mov r12,qword [rsp+24]
	mov rdi,qword [rsp+16]
	mov rsi,qword [rsp+8]
	mov r8,qword [rsp]
	mov r8,rax
	jmp ___merge..for_after_3
___merge..if_after_3:
	jmp ___merge..for_step_2
___merge..for_step_2:
	add r8,1
	jmp ___merge..for_cond_3
___merge..for_after_3:
	jmp ___merge..if_after_2
___merge..if_after_2:
	jmp ___merge..for_step_3
___merge..for_step_3:
	add rcx,1
	jmp ___merge..for_cond

___move:
___move..move.entry:
	push rbp
	mov rbp,rsp
	sub rsp,48
	mov rcx,qword [___a]
	mov rdi,qword [___now]
	mov rsi,0
	jmp ___move..for_cond
___move..for_cond:
	cmp rsi,rdi
	mov r8,0
	setl r8b
	cmp r8b,1
	jz ___move..for_loop
	jnz ___move..for_after
___move..for_after:
	mov r8,rdi
	imul r8,8
	add r8,rcx
	mov qword [r8+8],rdi
	mov r8,rdi
	add rdi,1
	mov qword [___now],rdi
	leave
	ret
___move..for_loop:
	mov r12,rsi
	imul r12,8
	add r12,rcx
	mov r8,rsi
	imul r8,8
	add r8,rcx
	mov r8,qword [r8+8]
	sub r8,1
	mov qword [r12+8],r8
	add rsi,1
	jmp ___move..for_cond

main:
main..main.entry:
	push rbp
	mov rbp,rsp
	sub rsp,176
	mov r9,qword [___R]
	mov r10,qword [___a]
	mov qword [rsp+72],r10
	mov r10,___string_3
	mov qword [rsp+16],r10
	mov r13,qword [___now]
	mov rcx,qword [___n]
	mov r10,qword [___h]
	mov qword [rsp+56],r10
	mov rdi,___string_4
	mov r12,qword [___M]
	mov r10,qword [___Q]
	mov qword [rsp+24],r10
	mov r10,___string_5
	mov qword [rsp+8],r10
	mov r15,___string_6
	mov rsi,___string_7
	mov r10,qword [___A]
	mov qword [rsp+32],r10
	mov rbx,___string_8
	mov r10,qword [rsp+56]
	mov qword [___h],r10
	mov qword [___R],r9
	mov r10,qword [rsp+72]
	mov qword [___a],r10
	mov r10,qword [rsp+24]
	mov qword [___Q],r10
	mov qword [___now],r13
	mov qword [___n],rcx
	mov qword [rsp+88],r8
	mov qword [rsp+96],rsi
	mov qword [rsp+104],rdi
	mov qword [rsp+112],r12
	mov qword [rsp+120],rcx
	mov qword [rsp+128],rdx
	mov qword [rsp+136],r15
	mov qword [rsp+144],r9
	mov qword [rsp+152],rbx
	call ____init
	mov rbx,qword [rsp+152]
	mov r9,qword [rsp+144]
	mov r15,qword [rsp+136]
	mov rdx,qword [rsp+128]
	mov rcx,qword [rsp+120]
	mov r12,qword [rsp+112]
	mov rdi,qword [rsp+104]
	mov rsi,qword [rsp+96]
	mov r8,qword [rsp+88]
	mov r10,qword [___A]
	mov qword [rsp+32],r10
	mov r10,qword [___Q]
	mov qword [rsp+24],r10
	mov r12,qword [___M]
	mov r10,qword [___h]
	mov qword [rsp+56],r10
	mov rcx,qword [___n]
	mov r13,qword [___now]
	mov r10,qword [___a]
	mov qword [rsp+72],r10
	mov r9,qword [___R]
	mov r10,0
	mov qword [rsp+40],r10
	mov r10,0
	mov qword [rsp+80],r10
	mov r14,0
	mov rcx,210
	mov r10,0
	mov qword [rsp+56],r10
	mov r9,808
	mov qword [rsp+88],r8
	mov qword [rsp+96],rsi
	mov qword [rsp+104],rdi
	mov qword [rsp+120],rcx
	mov qword [rsp+128],rdx
	mov qword [rsp+144],r9
	mov rdi,r9
	call malloc
	mov r9,qword [rsp+144]
	mov rdx,qword [rsp+128]
	mov rcx,qword [rsp+120]
	mov rdi,qword [rsp+104]
	mov rsi,qword [rsp+96]
	mov r8,qword [rsp+88]
	mov r9,rax
	mov qword [r9],100
	mov r10,r9
	mov qword [rsp+72],r10
	mov rax,r12
	mov r11,rdx
	cqo
	mov r10,qword [rsp+32]
	idiv r10
	mov rdx,r11
	mov r8,rax
	mov r10,r8
	mov qword [rsp+24],r10
	mov rax,r12
	mov r11,rdx
	cqo
	mov r10,qword [rsp+32]
	idiv r10
	mov r10,rdx
	mov qword [rsp+64],r10
	mov rdx,r11
	mov r10,qword [rsp+64]
	mov r9,r10
	mov r10,qword [rsp+56]
	mov qword [___h],r10
	mov qword [rsp+88],r8
	mov qword [rsp+96],rsi
	mov qword [rsp+104],rdi
	mov qword [rsp+112],r12
	mov qword [rsp+120],rcx
	mov rdi,qword [rsp+120]
	call ___pd
	mov rcx,qword [rsp+120]
	mov r12,qword [rsp+112]
	mov rdi,qword [rsp+104]
	mov rsi,qword [rsp+96]
	mov r8,qword [rsp+88]
	mov r8,rax
	mov r10,qword [___h]
	mov qword [rsp+56],r10
	xor r8,1
	cmp r8b,1
	jz main..if_true
	jnz main..if_after
main..if_after:
	mov qword [rsp+88],r8
	mov qword [rsp+96],rsi
	mov qword [rsp+104],rdi
	mov qword [rsp+120],rcx
	mov qword [rsp+128],rdx
	mov qword [rsp+144],r9
	mov rdi,qword [rsp+104]
	call _Z7printlnPc
	mov r9,qword [rsp+144]
	mov rdx,qword [rsp+128]
	mov rcx,qword [rsp+120]
	mov rdi,qword [rsp+104]
	mov rsi,qword [rsp+96]
	mov r8,qword [rsp+88]
	mov qword [rsp+88],r8
	mov qword [rsp+104],rdi
	mov rdi,3654898
	call ___initialize
	mov rdi,qword [rsp+104]
	mov r8,qword [rsp+88]
	mov r8,rax
	mov qword [___R],r9
	mov r10,qword [rsp+24]
	mov qword [___Q],r10
	mov qword [rsp+88],r8
	mov qword [rsp+96],rsi
	mov qword [rsp+104],rdi
	mov qword [rsp+112],r12
	mov qword [rsp+120],rcx
	mov qword [rsp+128],rdx
	mov qword [rsp+136],r15
	call ___random
	mov r15,qword [rsp+136]
	mov rdx,qword [rsp+128]
	mov rcx,qword [rsp+120]
	mov r12,qword [rsp+112]
	mov rdi,qword [rsp+104]
	mov rsi,qword [rsp+96]
	mov r8,qword [rsp+88]
	mov r8,rax
	mov rax,r8
	mov r11,rdx
	cqo
	mov r10,10
	idiv r10
	mov r10,rdx
	mov qword [rsp+48],r10
	mov rdx,r11
	mov r10,qword [rsp+48]
	mov r13,r10
	add r13,1
	mov qword [rsp+88],r8
	mov qword [rsp+96],rsi
	mov qword [rsp+104],rdi
	mov qword [rsp+120],rcx
	mov qword [rsp+128],rdx
	mov qword [rsp+144],r9
	mov rdi,r13
	call _Z10printlnInti
	mov r9,qword [rsp+144]
	mov rdx,qword [rsp+128]
	mov rcx,qword [rsp+120]
	mov rdi,qword [rsp+104]
	mov rsi,qword [rsp+96]
	mov r8,qword [rsp+88]
	jmp main..for_cond
main..for_cond:
	mov r8,r13
	sub r8,1
	mov r10,qword [rsp+40]
	cmp r10,r8
	mov r8,0
	setl r8b
	cmp r8b,1
	jz main..for_loop
	jnz main..for_after
main..for_after:
	mov r8,rcx
	mov r10,qword [rsp+80]
	sub r8,r10
	mov rdi,r8
	mov r8,r13
	sub r8,1
	imul r8,8
	mov r10,qword [rsp+72]
	add r8,r10
	mov qword [r8+8],rdi
	mov r10,qword [rsp+72]
	mov qword [___a],r10
	mov qword [___now],r13
	mov qword [rsp+88],r8
	mov qword [rsp+96],rsi
	mov qword [rsp+104],rdi
	mov qword [rsp+112],r12
	mov qword [rsp+120],rcx
	mov qword [rsp+128],rdx
	call ___show
	mov rdx,qword [rsp+128]
	mov rcx,qword [rsp+120]
	mov r12,qword [rsp+112]
	mov rdi,qword [rsp+104]
	mov rsi,qword [rsp+96]
	mov r8,qword [rsp+88]
	mov r8,rax
	mov r10,qword [rsp+72]
	mov qword [___a],r10
	mov qword [___now],r13
	mov qword [rsp+88],r8
	mov qword [rsp+96],rsi
	mov qword [rsp+104],rdi
	mov qword [rsp+112],r12
	mov qword [rsp+120],rcx
	call ___merge
	mov rcx,qword [rsp+120]
	mov r12,qword [rsp+112]
	mov rdi,qword [rsp+104]
	mov rsi,qword [rsp+96]
	mov r8,qword [rsp+88]
	mov r8,rax
	mov r13,qword [___now]
	jmp main..while_cond
main..while_cond:
	mov r10,qword [rsp+56]
	mov qword [___h],r10
	mov r10,qword [rsp+72]
	mov qword [___a],r10
	mov qword [___now],r13
	mov qword [rsp+88],r8
	mov qword [rsp+96],rsi
	mov qword [rsp+104],rdi
	mov qword [rsp+112],r12
	mov qword [rsp+120],rcx
	mov qword [rsp+128],rdx
	mov qword [rsp+136],r15
	call ___win
	mov r15,qword [rsp+136]
	mov rdx,qword [rsp+128]
	mov rcx,qword [rsp+120]
	mov r12,qword [rsp+112]
	mov rdi,qword [rsp+104]
	mov rsi,qword [rsp+96]
	mov r8,qword [rsp+88]
	mov r8,rax
	xor r8,1
	cmp r8b,1
	jz main..while_loop
	jnz main..while_after
main..while_loop:
	mov qword [rsp+88],r8
	mov qword [rsp+96],rsi
	mov qword [rsp+104],rdi
	mov qword [rsp+120],rcx
	mov qword [rsp+128],rdx
	mov qword [rsp+144],r9
	mov rdi,rbx
	call _Z5printPc
	mov r9,qword [rsp+144]
	mov rdx,qword [rsp+128]
	mov rcx,qword [rsp+120]
	mov rdi,qword [rsp+104]
	mov rsi,qword [rsp+96]
	mov r8,qword [rsp+88]
	add r14,1
	mov qword [rsp+88],r8
	mov qword [rsp+96],rsi
	mov qword [rsp+104],rdi
	mov qword [rsp+120],rcx
	mov qword [rsp+128],rdx
	mov qword [rsp+144],r9
	mov rdi,r14
	call _Z8printInti
	mov r9,qword [rsp+144]
	mov rdx,qword [rsp+128]
	mov rcx,qword [rsp+120]
	mov rdi,qword [rsp+104]
	mov rsi,qword [rsp+96]
	mov r8,qword [rsp+88]
	mov qword [rsp+88],r8
	mov qword [rsp+96],rsi
	mov qword [rsp+104],rdi
	mov qword [rsp+120],rcx
	mov qword [rsp+128],rdx
	mov qword [rsp+144],r9
	mov rdi,qword [rsp+16]
	call _Z7printlnPc
	mov r9,qword [rsp+144]
	mov rdx,qword [rsp+128]
	mov rcx,qword [rsp+120]
	mov rdi,qword [rsp+104]
	mov rsi,qword [rsp+96]
	mov r8,qword [rsp+88]
	mov r10,qword [rsp+72]
	mov qword [___a],r10
	mov qword [___now],r13
	mov qword [rsp+88],r8
	mov qword [rsp+96],rsi
	mov qword [rsp+104],rdi
	mov qword [rsp+112],r12
	mov qword [rsp+120],rcx
	call ___move
	mov rcx,qword [rsp+120]
	mov r12,qword [rsp+112]
	mov rdi,qword [rsp+104]
	mov rsi,qword [rsp+96]
	mov r8,qword [rsp+88]
	mov r8,rax
	mov r13,qword [___now]
	mov r10,qword [rsp+72]
	mov qword [___a],r10
	mov qword [___now],r13
	mov qword [rsp+88],r8
	mov qword [rsp+96],rsi
	mov qword [rsp+104],rdi
	mov qword [rsp+112],r12
	mov qword [rsp+120],rcx
	call ___merge
	mov rcx,qword [rsp+120]
	mov r12,qword [rsp+112]
	mov rdi,qword [rsp+104]
	mov rsi,qword [rsp+96]
	mov r8,qword [rsp+88]
	mov r8,rax
	mov r13,qword [___now]
	mov r10,qword [rsp+72]
	mov qword [___a],r10
	mov qword [___now],r13
	mov qword [rsp+88],r8
	mov qword [rsp+96],rsi
	mov qword [rsp+104],rdi
	mov qword [rsp+112],r12
	mov qword [rsp+120],rcx
	mov qword [rsp+128],rdx
	call ___show
	mov rdx,qword [rsp+128]
	mov rcx,qword [rsp+120]
	mov r12,qword [rsp+112]
	mov rdi,qword [rsp+104]
	mov rsi,qword [rsp+96]
	mov r8,qword [rsp+88]
	mov r8,rax
	jmp main..while_cond
main..while_after:
	mov qword [rsp+88],r8
	mov qword [rsp+96],rsi
	mov qword [rsp+104],rdi
	mov qword [rsp+120],rcx
	mov qword [rsp+128],rdx
	mov qword [rsp+144],r9
	mov rdi,qword [rsp+96]
	call _Z5printPc
	mov r9,qword [rsp+144]
	mov rdx,qword [rsp+128]
	mov rcx,qword [rsp+120]
	mov rdi,qword [rsp+104]
	mov rsi,qword [rsp+96]
	mov r8,qword [rsp+88]
	mov qword [rsp+88],r8
	mov qword [rsp+96],rsi
	mov qword [rsp+104],rdi
	mov qword [rsp+120],rcx
	mov qword [rsp+128],rdx
	mov qword [rsp+144],r9
	mov rdi,r14
	call _Z8printInti
	mov r9,qword [rsp+144]
	mov rdx,qword [rsp+128]
	mov rcx,qword [rsp+120]
	mov rdi,qword [rsp+104]
	mov rsi,qword [rsp+96]
	mov r8,qword [rsp+88]
	mov qword [rsp+88],r8
	mov qword [rsp+96],rsi
	mov qword [rsp+104],rdi
	mov qword [rsp+120],rcx
	mov qword [rsp+128],rdx
	mov qword [rsp+144],r9
	mov rdi,r15
	call _Z7printlnPc
	mov r9,qword [rsp+144]
	mov rdx,qword [rsp+128]
	mov rcx,qword [rsp+120]
	mov rdi,qword [rsp+104]
	mov rsi,qword [rsp+96]
	mov r8,qword [rsp+88]
	mov r8,0
	jmp main..main.exit
main..for_loop:
	mov qword [___R],r9
	mov r10,qword [rsp+24]
	mov qword [___Q],r10
	mov qword [rsp+88],r8
	mov qword [rsp+96],rsi
	mov qword [rsp+104],rdi
	mov qword [rsp+112],r12
	mov qword [rsp+120],rcx
	mov qword [rsp+128],rdx
	mov qword [rsp+136],r15
	call ___random
	mov r15,qword [rsp+136]
	mov rdx,qword [rsp+128]
	mov rcx,qword [rsp+120]
	mov r12,qword [rsp+112]
	mov rdi,qword [rsp+104]
	mov rsi,qword [rsp+96]
	mov r8,qword [rsp+88]
	mov r8,rax
	mov rax,r8
	mov r11,rdx
	cqo
	mov r10,10
	idiv r10
	mov r8,rdx
	add r8,1
	mov r10,qword [rsp+40]
	mov rdi,r10
	imul rdi,8
	mov r10,qword [rsp+72]
	add rdi,r10
	mov qword [rdi+8],r8
	jmp main..while_cond_2
main..while_cond_2:
	mov r10,qword [rsp+40]
	mov r8,r10
	imul r8,8
	mov r10,qword [rsp+72]
	add r8,r10
	mov r8,qword [r8+8]
	mov r10,qword [rsp+80]
	add r8,r10
	cmp r8,rcx
	mov r8,0
	setg r8b
	cmp r8b,1
	jz main..while_loop_2
	jnz main..while_after_2
main..while_after_2:
	mov r10,qword [rsp+40]
	mov rdi,r10
	imul rdi,8
	mov r10,qword [rsp+72]
	add rdi,r10
	mov rdi,qword [rdi+8]
	mov r10,qword [rsp+80]
	mov r8,r10
	add r8,rdi
	mov r10,r8
	mov qword [rsp+80],r10
	jmp main..for_step
main..for_step:
	mov r10,qword [rsp+40]
	add r10,1
	mov qword [rsp+40],r10
	jmp main..for_cond
main..while_loop_2:
	mov qword [___R],r9
	mov r10,qword [rsp+24]
	mov qword [___Q],r10
	mov qword [rsp+88],r8
	mov qword [rsp+96],rsi
	mov qword [rsp+104],rdi
	mov qword [rsp+112],r12
	mov qword [rsp+120],rcx
	mov qword [rsp+128],rdx
	mov qword [rsp+136],r15
	call ___random
	mov r15,qword [rsp+136]
	mov rdx,qword [rsp+128]
	mov rcx,qword [rsp+120]
	mov r12,qword [rsp+112]
	mov rdi,qword [rsp+104]
	mov rsi,qword [rsp+96]
	mov r8,qword [rsp+88]
	mov r8,rax
	mov rax,r8
	mov r11,rdx
	cqo
	mov r10,10
	idiv r10
	mov r10,rdx
	mov qword [rsp],r10
	mov rdx,r11
	mov r10,qword [rsp]
	mov r8,r10
	add r8,1
	mov r10,qword [rsp+40]
	mov rdi,r10
	imul rdi,8
	mov r10,qword [rsp+72]
	add rdi,r10
	mov qword [rdi+8],r8
	jmp main..while_cond_2
main..if_true:
	mov qword [rsp+88],r8
	mov qword [rsp+96],rsi
	mov qword [rsp+104],rdi
	mov qword [rsp+120],rcx
	mov qword [rsp+128],rdx
	mov qword [rsp+144],r9
	mov rdi,qword [rsp+8]
	call _Z7printlnPc
	mov r9,qword [rsp+144]
	mov rdx,qword [rsp+128]
	mov rcx,qword [rsp+120]
	mov rdi,qword [rsp+104]
	mov rsi,qword [rsp+96]
	mov r8,qword [rsp+88]
	mov r8,1
	jmp main..main.exit
main..main.exit:
	mov r10,qword [rsp+56]
	mov qword [___h],r10
	mov qword [___R],r9
	mov r10,qword [rsp+72]
	mov qword [___a],r10
	mov r10,qword [rsp+24]
	mov qword [___Q],r10
	mov qword [___now],r13
	mov qword [___n],rcx
	mov rax,r8
	leave
	ret

____init:
____init.._init.entry:
	push rbp
	mov rbp,rsp
	sub rsp,80
	mov r12,qword [___h]
	mov rdi,qword [___R]
	mov rdx,qword [___seed]
	mov r9,qword [___a]
	mov rcx,qword [___M]
	mov rbx,qword [___Q]
	mov r15,qword [___now]
	mov r8,qword [___n]
	mov rsi,qword [___A]
	mov r8,0
	mov r12,0
	mov r15,0
	mov r9,0
	mov rsi,48271
	mov rcx,2147483647
	mov rbx,0
	mov rdi,0
	mov rdx,1
	mov qword [___h],r12
	mov qword [___R],rdi
	mov qword [___seed],rdx
	mov qword [___a],r9
	mov qword [___M],rcx
	mov qword [___Q],rbx
	mov qword [___now],r15
	mov qword [___n],r8
	mov qword [___A],rsi
	leave
	ret

	section .data
___string:
	db 1,0,0,0,0,0,0,0,32,0
___string_2:
	db 0,0,0,0,0,0,0,0,0
___string_5:
	db 79,0,0,0,0,0,0,0,83,111,114,114,121,44,32,116,104,101,32,110,117,109,98,101,114,32,110,32,109,117,115,116,32,98,101,32,97,32,110,117,109,98,101,114,32,115,46,116,46,32,116,104,101,114,101,32,101,120,105,115,116,115,32,105,32,115,97,116,105,115,102,121,105,110,103,32,110,61,49,43,50,43,46,46,46,43,105,0
___string_4:
	db 12,0,0,0,0,0,0,0,76,101,116,39,115,32,115,116,97,114,116,33,0
___string_8:
	db 5,0,0,0,0,0,0,0,115,116,101,112,32,0
___string_3:
	db 1,0,0,0,0,0,0,0,58,0
___string_7:
	db 7,0,0,0,0,0,0,0,84,111,116,97,108,58,32,0
___string_6:
	db 8,0,0,0,0,0,0,0,32,115,116,101,112,40,115,41,0

section .bss
___n:
	resb 64
___h:
	resb 64
___now:
	resb 64
___a:
	resb 64
___A:
	resb 64
___M:
	resb 64
___Q:
	resb 64
___R:
	resb 64
___seed:
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


