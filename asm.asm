	global main

	section .text

_lol:
_lol..lol.entry:
	push rbp
	mov rbp,rsp
	sub rsp,80
	mov [rbp-16],rdi
	mov r8,[rbp-16]
	mov r9,r8
	mov [rbp-24],r9
	mov r8,[rbp-16]
	add r8,1
	mov [rbp-16],r8
	mov r8,[rbp-16]
	mov r9,r8
	mov [rbp-8],r9
	mov r8,[rbp-24]
	mov r9,r8
	mov [rbp-16],r9
	mov r8,[rbp-8]
	mov rax,r8
	leave
	ret

main:
main..main.entry:
	push rbp
	mov rbp,rsp
	sub rsp,64
	mov r8,[___x]
	mov [rbp-8],r8
	call __init
	mov r8,[___x]
	mov [rbp-8],r8
	mov r8,[rbp-8]
	mov rax,r8
	leave
	ret

__init:
__init.._init.entry:
	push rbp
	mov rbp,rsp
	sub rsp,80
	mov r8,[___c]
	mov [rbp-16],r8
	mov r8,[___x]
	mov [rbp-8],r8
	mov r8,123
	mov [rbp-16],r8
	mov [rbp-32],rdi
	mov rdi,[rbp-16]
	call _lol
	mov rdi,[rbp-32]
	mov r8,rax
	mov [rbp-24],r8
	mov r8,[rbp-24]
	mov r9,r8
	mov [rbp-8],r9
	mov r8,[rbp-16]
	mov [___c],r8
	mov r8,[rbp-8]
	mov [___x],r8
	leave
	ret

	section .data

	section .bss
___c:
	resb 64
___x:
	resb 64
