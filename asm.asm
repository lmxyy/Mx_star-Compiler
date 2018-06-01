	global main

	extern malloc

	section .text

main:
main..main.entry:
	push rbp
	mov rbp,rsp
	sub rsp,192
	call __init
	mov r8,5
	mov qword [rbp-112],r8
	mov r8,0
	mov qword [rbp-40],r8
	mov r8,0
	mov qword [rbp-48],r8
	mov r8,qword [rbp-40]
	cmp r8,0
	mov r9,0
	setne r9b
	mov qword [rbp-120],r9
	mov r8,qword [rbp-120]
	cmp r8,1
	jz main..lhs_true
	jnz main..lhs_false
main..lhs_false:
	mov r8,0
	mov qword [rbp-8],r8
	jmp main..lhs_merge
main..lhs_true:
	mov r8,qword [rbp-112]
	mov rax,r8
	cdqe
	mov r8,qword [rbp-40]
	mov r9,qword [rbp-80]
	idiv r8
	mov qword [rbp-80],r9
	mov r8,rax
	mov qword [rbp-80],r8
	mov r8,qword [rbp-80]
	cmp r8,1
	mov r9,0
	setne r9b
	mov qword [rbp-104],r9
	mov r8,qword [rbp-104]
	mov r9,r8
	mov qword [rbp-8],r9
	jmp main..lhs_merge
main..lhs_merge:
	mov r8,qword [rbp-8]
	mov r9,r8
	mov qword [rbp-24],r9
	mov r8,qword [rbp-24]
	cmp r8,1
	jz main..if_true
	jnz main..if_false
main..if_true:
	mov r8,10
	mov qword [rbp-48],r8
	jmp main..if_after
main..if_false:
	mov r8,20
	mov qword [rbp-48],r8
	jmp main..if_after
main..if_after:
	mov r8,0
	mov qword [rbp-72],r8
	mov r8,qword [rbp-48]
	cmp r8,10
	mov r9,0
	sete r9b
	mov qword [rbp-136],r9
	mov r8,qword [rbp-136]
	cmp r8,1
	jz main..lhs_true_2
	jnz main..lhs_false_2
main..lhs_true_2:
	mov r8,qword [rbp-112]
	mov rax,r8
	cdqe
	mov r8,qword [rbp-40]
	mov r9,qword [rbp-128]
	idiv r8
	mov qword [rbp-128],r9
	mov r8,rax
	mov qword [rbp-128],r8
	mov r8,qword [rbp-128]
	cmp r8,0
	mov r9,0
	sete r9b
	mov qword [rbp-16],r9
	mov r8,qword [rbp-16]
	mov r9,r8
	mov qword [rbp-88],r9
	jmp main..lhs_merge_2
main..lhs_false_2:
	mov r8,0
	mov qword [rbp-88],r8
	jmp main..lhs_merge_2
main..lhs_merge_2:
	mov r8,qword [rbp-88]
	cmp r8,1
	jz main..lhs_true_3
	jnz main..lhs_false_3
main..lhs_false_3:
	mov r8,0
	mov qword [rbp-32],r8
	jmp main..lhs_merge_3
main..lhs_true_3:
	mov r8,qword [rbp-112]
	cmp r8,5
	mov r9,0
	sete r9b
	mov qword [rbp-64],r9
	mov r8,qword [rbp-64]
	mov r9,r8
	mov qword [rbp-32],r9
	jmp main..lhs_merge_3
main..lhs_merge_3:
	mov r8,qword [rbp-32]
	mov r9,r8
	mov qword [rbp-96],r9
	mov r8,qword [rbp-32]
	xor r8,1
	mov qword [rbp-32],r8
	mov r8,qword [rbp-32]
	mov r9,r8
	mov qword [rbp-56],r9
	mov r8,qword [rbp-96]
	mov r9,r8
	mov qword [rbp-32],r9
	mov r8,qword [rbp-56]
	mov r9,r8
	mov qword [rbp-72],r9
	mov r8,qword [rbp-72]
	cmp r8,1
	jz main..if_true_2
	jnz main..if_after_2
main..if_true_2:
	mov r8,30
	mov qword [rbp-48],r8
	jmp main..if_after_2
main..if_after_2:
	mov r8,qword [rbp-48]
	mov rax,r8
	leave
	ret

__init:
__init.._init.entry:
	push rbp
	mov rbp,rsp
	sub rsp,48
	leave
	ret

	section .data

	section .bss
