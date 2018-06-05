global main

extern malloc
section .text

___random:
___random..random.entry:
	push rbp
	mov rbp,rsp
	sub rsp,64
	mov rdi,qword [___A]
	mov rdx,qword [___seed]
	mov rcx,qword [___R]
	mov rsi,qword [___M]
	mov r12,qword [___Q]
	mov rax,rdx
	mov r11,rdx
	cqo
	idiv r12
	mov r8,rdx
	mov rdx,r11
	imul rdi,r8
	mov rax,rdx
	mov r11,rdx
	cqo
	idiv r12
	mov rdx,r11
	mov r15,rax
	imul rcx,r15
	mov r8,rdi
	sub r8,rcx
	cmp r8,0
	mov rdi,0
	setge dil
	cmp dil,1
	jz ___random..if_true
	jnz ___random..if_false
___random..if_false:
	mov rdx,r8
	add rdx,rsi
	jmp ___random..if_after
___random..if_true:
	mov rdx,r8
	jmp ___random..if_after
___random..if_after:
	mov qword [___seed],rdx
	mov rax,rdx
	leave
	ret

___initialize:
___initialize..initialize.entry:
	push rbp
	mov rbp,rsp
	sub rsp,16
	mov r8,qword [