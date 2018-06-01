	global main

	extern malloc

	section .text

_tak:
_tak..tak.entry:
	push rbp
	mov rbp,rsp
	sub rsp,192
	mov qword [rbp-80],rdi
	mov qword [rbp-32],rsi
	mov qword [rbp-136],rdx
	mov r8,qword [rbp-32]
	mov r9,qword [rbp-80]
	cmp r8,r9
	mov r10,0
	setl r10b
	mov qword [rbp-56],r10
	mov r8,qword [rbp-56]
	cmp r8,1
	jz _tak..if_true
	jnz _tak..if_false
_tak..if_true:
	mov r8,qword [rbp-80]
	mov r9,r8
	mov qword [rbp-104],r9
	mov r8,qword [rbp-80]
	sub r8,1
	mov qword [rbp-80],r8
	mov r8,qword [rbp-80]
	mov r9,r8
	mov qword [rbp-128],r9
	mov r8,qword [rbp-104]
	mov r9,r8
	mov qword [rbp-80],r9
	mov qword [rbp-144],rdi
	mov qword [rbp-152],rsi
	mov qword [rbp-160],rdx
	mov rdx,qword [rbp-136]
	mov rsi,qword [rbp-32]
	mov rdi,qword [rbp-128]
	call _tak
	mov rdx,qword [rbp-160]
	mov rsi,qword [rbp-152]
	mov rdi,qword [rbp-144]
	mov r8,rax
	mov qword [rbp-64],r8
	mov r8,qword [rbp-32]
	mov r9,r8
	mov qword [rbp-48],r9
	mov r8,qword [rbp-32]
	sub r8,1
	mov qword [rbp-32],r8
	mov r8,qword [rbp-32]
	mov r9,r8
	mov qword [rbp-16],r9
	mov r8,qword [rbp-48]
	mov r9,r8
	mov qword [rbp-32],r9
	mov qword [rbp-144],rdi
	mov qword [rbp-152],rsi
	mov qword [rbp-160],rdx
	mov rdx,qword [rbp-80]
	mov rsi,qword [rbp-136]
	mov rdi,qword [rbp-16]
	call _tak
	mov rdx,qword [rbp-160]
	mov rsi,qword [rbp-152]
	mov rdi,qword [rbp-144]
	mov r8,rax
	mov qword [rbp-112],r8
	mov r8,qword [rbp-136]
	mov r9,r8
	mov qword [rbp-72],r9
	mov r8,qword [rbp-136]
	sub r8,1
	mov qword [rbp-136],r8
	mov r8,qword [rbp-136]
	mov r9,r8
	mov qword [rbp-120],r9
	mov r8,qword [rbp-72]
	mov r9,r8
	mov qword [rbp-136],r9
	mov qword [rbp-144],rdi
	mov qword [rbp-152],rsi
	mov qword [rbp-160],rdx
	mov rdx,qword [rbp-32]
	mov rsi,qword [rbp-80]
	mov rdi,qword [rbp-120]
	call _tak
	mov rdx,qword [rbp-160]
	mov rsi,qword [rbp-152]
	mov rdi,qword [rbp-144]
	mov r8,rax
	mov qword [rbp-8],r8
	mov qword [rbp-144],rdi
	mov qword [rbp-152],rsi
	mov qword [rbp-160],rdx
	mov rdx,qword [rbp-8]
	mov rsi,qword [rbp-112]
	mov rdi,qword [rbp-64]
	call _tak
	mov rdx,qword [rbp-160]
	mov rsi,qword [rbp-152]
	mov rdi,qword [rbp-144]
	mov r8,rax
	mov qword [rbp-96],r8
	mov r8,qword [rbp-96]
	mov r9,r8
	mov qword [rbp-24],r9
	mov r8,qword [rbp-96]
	add r8,1
	mov qword [rbp-96],r8
	mov r8,qword [rbp-96]
	mov r9,r8
	mov qword [rbp-88],r9
	mov r8,qword [rbp-24]
	mov r9,r8
	mov qword [rbp-96],r9
	mov r8,qword [rbp-88]
	mov r9,r8
	mov qword [rbp-40],r9
	jmp _tak..tak.exit
_tak..if_false:
	mov r8,qword [rbp-136]
	mov r9,r8
	mov qword [rbp-40],r9
	jmp _tak..tak.exit
_tak..tak.exit:
	mov r8,qword [rbp-40]
	mov rax,r8
	leave
	ret

main:
main..main.entry:
	push rbp
	mov rbp,rsp
	sub rsp,64
	call __init
	mov qword [rbp-16],rdi
	mov qword [rbp-24],rsi
	mov qword [rbp-32],rdx
	mov rdx,6
	mov rsi,12
	mov rdi,18
	call _tak
	mov rdx,qword [rbp-32]
	mov rsi,qword [rbp-24]
	mov rdi,qword [rbp-16]
	mov r8,rax
	mov qword [rbp-8],r8
	mov r8,qword [rbp-8]
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
