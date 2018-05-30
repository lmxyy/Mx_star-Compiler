	global main

	section .text

main:
main..main.entry:
	push rbp
	mov rbp,rsp
	sub rsp,96
	call __init
	mov r8,1
	mov [rsp+24],r8
	mov r8,1
	mov [rsp+40],r8
	mov r8,[rsp+24]
	mov r9,r8
	mov [rsp+16],r9
	mov r8,[rsp+40]
	add r8,r8
	mov [rsp+24],r8
	mov r8,[rsp+24]
	mov [rsp+32],r8
	mov r8,[rsp+16]
	mov [rsp+24],r8
	mov r8,[rsp+32]
	mov r9,r8
	mov [rsp+8],r9
	mov r8,[rsp+8]
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
