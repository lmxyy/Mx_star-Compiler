	global main

	section .text

main:
main..main.entry:
	push rbp
	mov rbp,rsp
	sub rsp,96
	mov r8,[___a]
	mov [rbp-40],r8
	mov r8,[___b]
	mov [rbp-24],r8
	mov r8,[rbp-40]
	mov [___a],r8
	call __init
	mov r8,[___b]
	mov [rbp-24],r8
	mov r8,[___a]
	mov [rbp-40],r8
	mov r8,[rbp-40]
	mov r9,r8
	mov [rbp-32],r9
	mov r8,[rbp-24]
	mov r9,[rbp-40]
	add r9,r8
	mov [rbp-40],r9
	mov r8,[rbp-40]
	mov r9,r8
	mov [rbp-8],r9
	mov r8,[rbp-32]
	mov r9,r8
	mov [rbp-40],r9
	mov r8,[rbp-8]
	mov r9,r8
	mov [rbp-16],r9
	mov r8,[rbp-40]
	mov [___a],r8
	mov r8,[rbp-16]
	mov rax,r8
	leave
	ret

__init:
__init.._init.entry:
	push rbp
	mov rbp,rsp
	sub rsp,64
	mov r8,[___a]
	mov [rbp-16],r8
	mov r8,[___b]
	mov [rbp-8],r8
	mov r8,1
	mov [rbp-16],r8
	mov r8,2
	mov [rbp-8],r8
	mov r8,[rbp-16]
	mov [___a],r8
	mov r8,[rbp-8]
	mov [___b],r8
	leave
	ret

	section .data

	section .bss
___a:
	resb 64
___b:
	resb 64
