	global main

	section .text

main:
main..main.entry:
	push rbp
	mov rbp,rsp
	sub rsp,64
	call __init
	mov r8,1
	mov [rbp-16],r8
	jmp main..for_cond
main..for_cond:
	mov r8,[rbp-16]
	cmp r8,10
	mov r9,0
	setle r9b
	mov [rbp-8],r9
	mov r8,[rbp-8]
	cmp r8,1
	jz main..for_loop
	jnz main..for_after
main..for_after:
	mov rax,0
	leave
	ret
main..for_loop:
	jmp main..for_step
main..for_step:
	add r8,1
	mov [rbp-16],r8
	jmp main..for_cond

__init:
__init.._init.entry:
	push rbp
	mov rbp,rsp
	sub rsp,48
	leave
	ret

	section .data

	section .bss
