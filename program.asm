global main

extern malloc
section .text

___qsrt:
___qsrt..qsrt.entry:
	push rbp
	mov rbp,rsp
	sub rsp,368
	mov qword [rbp-16],rdi
	mov qword [rbp-168],rsi
	mov r8,qword [___a]
	mov qword [rbp-32],r8
	mov r8,qword [rbp-16]
	mov r9,r8
	mov qword [rbp-128],r9
	mov r8,qword [rbp-168]
	mov r9,r8
	mov qword [rbp-72],r9
	mov r8,qword [rbp-16]
	mov r9,r8
	mov qword [rbp-96],r9
	mov r8,qword [rbp-168]
	mov r9,qword [rbp-16]
	add r9,r8
	mov qword [rbp-16],r9
	mov r8,qword [rbp-16]
	mov r9,r8
	mov qword [rbp-160],r9
	mov r8,qword [rbp-96]
	mov r9,r8
	mov qword [rbp-16],r9
	mov r8,qword [rbp-160]
	mov rax,r8
	cqo
	mov r8,2
	mov qword [rbp-248],r8
	mov r8,qword [rbp-248]
	idiv r8
	mov r8,rax
	mov qword [rbp-296],r8
	mov r8,qword [rbp-296]
	mov r9,r8
	mov qword [rbp-280],r9
	mov r8,qword [rbp-296]
	imul r8,8
	mov qword [rbp-296],r8
	mov r8,qword [rbp-296]
	mov r9,r8
	mov qword [rbp-264],r9
	mov r8,qword [rbp-280]
	mov r9,r8
	mov qword [rbp-296],r9
	mov r8,qword [rbp-32]
	mov r9,qword [rbp-264]
	add r9,r8
	mov qword [rbp-264],r9
	mov r8,qword [rbp-264]
	mov r8,qword [r8+8]
	mov qword [rbp-264],r8
	mov r8,qword [rbp-264]
	mov r9,r8
	mov qword [rbp-8],r9
	jmp ___qsrt..while_cond
___qsrt..while_cond:
	mov r8,qword [rbp-128]
	mov r9,qword [rbp-72]
	cmp r8,r9
	mov r10,0
	setle r10b
	mov qword [rbp-104],r10
	mov r8,qword [rbp-104]
	cmp r8b,1
	jz ___qsrt..while_loop
	jnz ___qsrt..while_after
___qsrt..while_after:
	mov r8,qword [rbp-16]
	mov r9,qword [rbp-72]
	cmp r8,r9
	mov r10,0
	setl r10b
	mov qword [rbp-232],r10
	mov r8,qword [rbp-232]
	cmp r8b,1
	jz ___qsrt..if_true
	jnz ___qsrt..if_after
___qsrt..if_true:
	mov qword [rbp-304],r8
	mov qword [rbp-312],r10
	mov qword [rbp-320],r9
	mov qword [rbp-328],rdi
	mov qword [rbp-336],rsi
	mov rsi,qword [rbp-72]
	mov rdi,qword [rbp-16]
	call ___qsrt
	mov rsi,qword [rbp-336]
	mov rdi,qword [rbp-328]
	mov r9,qword [rbp-320]
	mov r10,qword [rbp-312]
	mov r8,qword [rbp-304]
	mov r8,rax
	mov qword [rbp-48],r8
	jmp ___qsrt..if_after
___qsrt..if_after:
	mov r8,qword [rbp-128]
	mov r9,qword [rbp-168]
	cmp r8,r9
	mov r10,0
	setl r10b
	mov qword [rbp-288],r10
	mov r8,qword [rbp-288]
	cmp r8b,1
	jz ___qsrt..if_true_2
	jnz ___qsrt..if_after_2
___qsrt..if_true_2:
	mov qword [rbp-304],r8
	mov qword [rbp-312],r10
	mov qword [rbp-320],r9
	mov qword [rbp-328],rdi
	mov qword [rbp-336],rsi
	mov rsi,qword [rbp-168]
	mov rdi,qword [rbp-128]
	call ___qsrt
	mov rsi,qword [rbp-336]
	mov rdi,qword [rbp-328]
	mov r9,qword [rbp-320]
	mov r10,qword [rbp-312]
	mov r8,qword [rbp-304]
	mov r8,rax
	mov qword [rbp-256],r8
	jmp ___qsrt..if_after_2
___qsrt..if_after_2:
	mov rax,0
	leave
	ret
___qsrt..while_loop:
	jmp ___qsrt..while_cond_2
___qsrt..while_cond_2:
	mov r8,qword [rbp-128]
	mov r9,r8
	mov qword [rbp-152],r9
	mov r8,qword [rbp-128]
	imul r8,8
	mov qword [rbp-128],r8
	mov r8,qword [rbp-128]
	mov r9,r8
	mov qword [rbp-176],r9
	mov r8,qword [rbp-152]
	mov r9,r8
	mov qword [rbp-128],r9
	mov r8,qword [rbp-32]
	mov r9,qword [rbp-176]
	add r9,r8
	mov qword [rbp-176],r9
	mov r8,qword [rbp-176]
	mov r8,qword [r8+8]
	mov qword [rbp-176],r8
	mov r8,qword [rbp-176]
	mov r9,qword [rbp-8]
	cmp r8,r9
	mov r10,0
	setl r10b
	mov qword [rbp-88],r10
	mov r8,qword [rbp-88]
	cmp r8b,1
	jz ___qsrt..while_loop_2
	jnz ___qsrt..while_after_2
___qsrt..while_after_2:
	jmp ___qsrt..while_cond_3
___qsrt..while_cond_3:
	mov r8,qword [rbp-72]
	mov r9,r8
	mov qword [rbp-64],r9
	mov r8,qword [rbp-72]
	imul r8,8
	mov qword [rbp-72],r8
	mov r8,qword [rbp-72]
	mov r9,r8
	mov qword [rbp-200],r9
	mov r8,qword [rbp-64]
	mov r9,r8
	mov qword [rbp-72],r9
	mov r8,qword [rbp-32]
	mov r9,qword [rbp-200]
	add r9,r8
	mov qword [rbp-200],r9
	mov r8,qword [rbp-200]
	mov r8,qword [r8+8]
	mov qword [rbp-200],r8
	mov r8,qword [rbp-200]
	mov r9,qword [rbp-8]
	cmp r8,r9
	mov r10,0
	setg r10b
	mov qword [rbp-208],r10
	mov r8,qword [rbp-208]
	cmp r8b,1
	jz ___qsrt..while_loop_3
	jnz ___qsrt..while_after_3
___qsrt..while_after_3:
	mov r8,qword [rbp-128]
	mov r9,qword [rbp-72]
	cmp r8,r9
	mov r10,0
	setle r10b
	mov qword [rbp-120],r10
	mov r8,qword [rbp-120]
	cmp r8b,1
	jz ___qsrt..if_true_3
	jnz ___qsrt..if_after_3
___qsrt..if_true_3:
	mov r8,qword [rbp-128]
	mov r9,r8
	mov qword [rbp-184],r9
	mov r8,qword [rbp-128]
	imul r8,8
	mov qword [rbp-128],r8
	mov r8,qword [rbp-128]
	mov r9,r8
	mov qword [rbp-224],r9
	mov r8,qword [rbp-184]
	mov r9,r8
	mov qword [rbp-128],r9
	mov r8,qword [rbp-32]
	mov r9,qword [rbp-224]
	add r9,r8
	mov qword [rbp-224],r9
	mov r8,qword [rbp-224]
	mov r8,qword [r8+8]
	mov qword [rbp-224],r8
	mov r8,qword [rbp-224]
	mov r9,r8
	mov qword [rbp-80],r9
	mov r8,qword [rbp-72]
	mov r9,r8
	mov qword [rbp-56],r9
	mov r8,qword [rbp-72]
	imul r8,8
	mov qword [rbp-72],r8
	mov r8,qword [rbp-72]
	mov r9,r8
	mov qword [rbp-144],r9
	mov r8,qword [rbp-56]
	mov r9,r8
	mov qword [rbp-72],r9
	mov r8,qword [rbp-32]
	mov r9,qword [rbp-144]
	add r9,r8
	mov qword [rbp-144],r9
	mov r8,qword [rbp-144]
	mov r8,qword [r8+8]
	mov qword [rbp-144],r8
	mov r8,qword [rbp-128]
	mov r9,r8
	mov qword [rbp-272],r9
	mov r8,qword [rbp-128]
	imul r8,8
	mov qword [rbp-128],r8
	mov r8,qword [rbp-128]
	mov r9,r8
	mov qword [rbp-216],r9
	mov r8,qword [rbp-272]
	mov r9,r8
	mov qword [rbp-128],r9
	mov r8,qword [rbp-32]
	mov r9,qword [rbp-216]
	add r9,r8
	mov qword [rbp-216],r9
	mov r8,qword [rbp-216]
	mov r9,qword [rbp-144]
	mov qword [r8+8],r9
	mov r8,qword [rbp-72]
	mov r9,r8
	mov qword [rbp-240],r9
	mov r8,qword [rbp-72]
	imul r8,8
	mov qword [rbp-72],r8
	mov r8,qword [rbp-72]
	mov r9,r8
	mov qword [rbp-136],r9
	mov r8,qword [rbp-240]
	mov r9,r8
	mov qword [rbp-72],r9
	mov r8,qword [rbp-32]
	mov r9,qword [rbp-136]
	add r9,r8
	mov qword [rbp-136],r9
	mov r8,qword [rbp-136]
	mov r9,qword [rbp-80]
	mov qword [r8+8],r9
	mov r8,qword [rbp-128]
	mov r9,r8
	mov qword [rbp-24],r9
	mov r8,qword [rbp-128]
	add r8,1
	mov qword [rbp-128],r8
	mov r8,qword [rbp-72]
	mov r9,r8
	mov qword [rbp-192],r9
	mov r8,qword [rbp-72]
	sub r8,1
	mov qword [rbp-72],r8
	jmp ___qsrt..if_after_3
___qsrt..if_after_3:
	jmp ___qsrt..while_cond
___qsrt..while_loop_3:
	mov r8,qword [rbp-72]
	mov r9,r8
	mov qword [rbp-40],r9
	mov r8,qword [rbp-72]
	sub r8,1
	mov qword [rbp-72],r8
	jmp ___qsrt..while_cond_3
___qsrt..while_loop_2:
	mov r8,qword [rbp-128]
	mov r9,r8
	mov qword [rbp-112],r9
	mov r8,qword [rbp-128]
	add r8,1
	mov qword [rbp-128],r8
	jmp ___qsrt..while_cond_2

main:
main..main.entry:
	push rbp
	mov rbp,rsp
	sub rsp,224
	mov r8,qword [___n]
	mov qword [rbp-144],r8
	mov r8,qword [___a]
	mov qword [rbp-96],r8
	mov r8,___string
	mov qword [rbp-80],r8
	mov r8,___string_2
	mov qword [rbp-88],r8
	mov r8,qword [rbp-144]
	mov qword [___n],r8
	mov qword [rbp-152],r8
	mov qword [rbp-168],r9
	call ____init
	mov r9,qword [rbp-168]
	mov r8,qword [rbp-152]
	mov r8,qword [___a]
	mov qword [rbp-96],r8
	mov r8,qword [___n]
	mov qword [rbp-144],r8
	mov r8,0
	mov qword [rbp-56],r8
	mov r8,1
	mov qword [rbp-56],r8
	jmp main..for_cond
main..for_cond:
	mov r8,qword [rbp-56]
	mov r9,qword [rbp-144]
	cmp r8,r9
	mov r10,0
	setle r10b
	mov qword [rbp-136],r10
	mov r8,qword [rbp-136]
	cmp r8b,1
	jz main..for_loop
	jnz main..for_after
main..for_after:
	mov qword [rbp-152],r8
	mov qword [rbp-160],r10
	mov qword [rbp-168],r9
	mov qword [rbp-176],rdi
	mov qword [rbp-184],rsi
	mov rsi,qword [rbp-144]
	mov rdi,1
	call ___qsrt
	mov rsi,qword [rbp-184]
	mov rdi,qword [rbp-176]
	mov r9,qword [rbp-168]
	mov r10,qword [rbp-160]
	mov r8,qword [rbp-152]
	mov r8,rax
	mov qword [rbp-16],r8
	mov r8,1
	mov qword [rbp-56],r8
	jmp main..for_cond_2
main..for_cond_2:
	mov r8,qword [rbp-56]
	mov r9,qword [rbp-144]
	cmp r8,r9
	mov r10,0
	setle r10b
	mov qword [rbp-104],r10
	mov r8,qword [rbp-104]
	cmp r8b,1
	jz main..for_loop_2
	jnz main..for_after_2
main..for_loop_2:
	mov r8,qword [rbp-56]
	mov r9,r8
	mov qword [rbp-32],r9
	mov r8,qword [rbp-56]
	imul r8,8
	mov qword [rbp-56],r8
	mov r8,qword [rbp-56]
	mov r9,r8
	mov qword [rbp-48],r9
	mov r8,qword [rbp-32]
	mov r9,r8
	mov qword [rbp-56],r9
	mov r8,qword [rbp-96]
	mov r9,qword [rbp-48]
	add r9,r8
	mov qword [rbp-48],r9
	mov r8,qword [rbp-48]
	mov r8,qword [r8+8]
	mov qword [rbp-48],r8
	mov qword [rbp-152],r8
	mov qword [rbp-160],r10
	mov qword [rbp-168],r9
	mov rdi,qword [rbp-48]
	call _Z8printInti
	mov r9,qword [rbp-168]
	mov r10,qword [rbp-160]
	mov r8,qword [rbp-152]
	mov qword [rbp-152],r8
	mov qword [rbp-160],r10
	mov qword [rbp-168],r9
	mov rdi,qword [rbp-80]
	call _Z5printPc
	mov r9,qword [rbp-168]
	mov r10,qword [rbp-160]
	mov r8,qword [rbp-152]
	jmp main..for_step
main..for_step:
	mov r8,qword [rbp-56]
	mov r9,r8
	mov qword [rbp-72],r9
	mov r8,qword [rbp-56]
	add r8,1
	mov qword [rbp-56],r8
	jmp main..for_cond_2
main..for_after_2:
	mov qword [rbp-152],r8
	mov qword [rbp-160],r10
	mov qword [rbp-168],r9
	mov rdi,qword [rbp-88]
	call _Z5printPc
	mov r9,qword [rbp-168]
	mov r10,qword [rbp-160]
	mov r8,qword [rbp-152]
	mov r8,qword [rbp-144]
	mov qword [___n],r8
	mov rax,0
	leave
	ret
main..for_loop:
	mov r8,qword [rbp-144]
	mov r9,r8
	mov qword [rbp-120],r9
	mov r8,qword [rbp-144]
	add r8,1
	mov qword [rbp-144],r8
	mov r8,qword [rbp-144]
	mov r9,r8
	mov qword [rbp-112],r9
	mov r8,qword [rbp-120]
	mov r9,r8
	mov qword [rbp-144],r9
	mov r8,qword [rbp-112]
	mov r9,r8
	mov qword [rbp-128],r9
	mov r8,qword [rbp-56]
	mov r9,qword [rbp-112]
	sub r9,r8
	mov qword [rbp-112],r9
	mov r8,qword [rbp-112]
	mov r9,r8
	mov qword [rbp-8],r9
	mov r8,qword [rbp-128]
	mov r9,r8
	mov qword [rbp-112],r9
	mov r8,qword [rbp-56]
	mov r9,r8
	mov qword [rbp-24],r9
	mov r8,qword [rbp-56]
	imul r8,8
	mov qword [rbp-56],r8
	mov r8,qword [rbp-56]
	mov r9,r8
	mov qword [rbp-64],r9
	mov r8,qword [rbp-24]
	mov r9,r8
	mov qword [rbp-56],r9
	mov r8,qword [rbp-96]
	mov r9,qword [rbp-64]
	add r9,r8
	mov qword [rbp-64],r9
	mov r8,qword [rbp-64]
	mov r9,qword [rbp-8]
	mov qword [r8+8],r9
	jmp main..for_step_2
main..for_step_2:
	mov r8,qword [rbp-56]
	mov r9,r8
	mov qword [rbp-40],r9
	mov r8,qword [rbp-56]
	add r8,1
	mov qword [rbp-56],r8
	jmp main..for_cond

____init:
____init.._init.entry:
	push rbp
	mov rbp,rsp
	sub rsp,96
	mov r8,qword [___n]
	mov qword [rbp-8],r8
	mov r8,qword [___a]
	mov qword [rbp-16],r8
	mov r8,80808
	mov qword [rbp-24],r8
	mov r8,qword [rbp-24]
	mov rdi,r8
	call malloc
	mov r8,rax
	mov qword [rbp-24],r8
	mov r8,qword [rbp-24]
	mov qword [r8],10100
	mov r8,qword [rbp-24]
	mov r9,r8
	mov qword [rbp-16],r9
	mov r8,10000
	mov qword [rbp-8],r8
	mov r8,qword [rbp-8]
	mov qword [___n],r8
	mov r8,qword [rbp-16]
	mov qword [___a],r8
	leave
	ret

	section .data
___string:
	db 0,0,0,0,0,0,0,1,32,0
___string_2:
	db 0,0,0,0,0,0,0,1,10,0

section .bss
___a:
	resb 64
___n:
	resb 64






default rel

global _Z15stringSubStringPcii
global _Z14stringParseIntPc
global _Z12stringConcatPcS_
global _Z9stringEquPcS_
global _Z10stringLessPcS_
global _Z9stringLeqPcS_
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

_Z5printPc:
        lea     rdx, [rdi+8H]
        mov     esi, L_060
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
        mov     edi, L_060
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
        push    rbp
        push    rbx
        sub     rsp, 72


        mov     rax, qword [fs:abs 28H]
        mov     qword [rsp+38H], rax
        xor     eax, eax
        test    edi, edi
        js      L_046
        jne     L_049
        mov     edi, 10
        call    malloc
        movzx   ebx, byte [rsp]
        mov     qword [rax], 1
        mov     byte [rax+9H], 0
        lea     edx, [rbx+30H]
        mov     byte [rax+8H], dl
L_045:  mov     rbx, qword [rsp+38H]


        xor     rbx, qword [fs:abs 28H]
        jne     L_059
        add     rsp, 72
        pop     rbx
        pop     rbp
        ret





ALIGN   8
L_046:  neg     edi
        mov     r9d, 1
L_047:  mov     eax, edi
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
        je      L_050
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
        je      L_051
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
        mov     dword [rsp+10H], r8d
        mov     r8d, 1759218605
        imul    r8d
        sar     edx, 12
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
        mov     dword [rsp+14H], r8d
        mov     r8d, 351843721
        imul    r8d
        sar     edx, 13
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
        mov     dword [rsp+18H], r8d
        mov     r8d, 1125899907
        imul    r8d
        sar     edx, 18
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
        mov     dword [rsp+1CH], r8d
        mov     r8d, 1801439851
        imul    r8d
        sar     edx, 22
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
        mov     dword [rsp+20H], r8d
        mov     r8d, 1441151881
        imul    r8d
        sar     edx, 25
        mov     r8d, edx
        sub     r8d, ecx
        je      L_057
        mov     eax, r8d
        imul    esi
        mov     eax, r8d
        sar     eax, 31
        mov     esi, edx
        mov     edx, 1152921505
        sar     esi, 2
        sub     esi, eax
        lea     eax, [rsi+rsi*4]
        add     eax, eax
        sub     r8d, eax
        mov     eax, edi
        imul    edx
        mov     dword [rsp+24H], r8d
        sar     edx, 28
        sub     edx, ecx
        je      L_058
        mov     dword [rsp+28H], edx
        mov     ebx, 9
        mov     ebp, 10
L_048:  lea     edi, [r9+rbp+9H]
        movsxd  rdi, edi
        call    malloc
        movsxd  rsi, ebx
        mov     qword [rax], rbp
        mov     byte [rax+rbp+8H], 0
        movzx   edi, byte [rsp+rsi*4]
        lea     ecx, [rdi+30H]
        mov     byte [rax+rsi+8H], cl
        lea     ecx, [rbx-1H]
        cmp     ecx, -1
        je      L_045
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-2H]
        cmp     ecx, -1
        je      L_045
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-3H]
        cmp     ecx, -1
        je      L_045
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-4H]
        cmp     ecx, -1
        je      L_045
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-5H]
        cmp     ecx, -1
        je      L_045
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-6H]
        cmp     ecx, -1
        je      L_045
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-7H]
        cmp     ecx, -1
        je      L_045
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-8H]
        cmp     ecx, -1
        je      L_045
        movsxd  rcx, ecx
        movzx   esi, byte [rsp+rcx*4]
        add     esi, 48
        cmp     ebx, 8
        mov     byte [rax+rcx+8H], sil
        je      L_045
        movzx   ebx, byte [rsp]
        lea     edx, [rbx+30H]
        mov     byte [rax+8H], dl
        jmp     L_045






ALIGN   16
L_049:  xor     r9d, r9d
        jmp     L_047





ALIGN   16
L_050:  xor     ebx, ebx
        mov     ebp, 1
        jmp     L_048





ALIGN   8
L_051:  mov     ebx, 1
        mov     ebp, 2
        jmp     L_048





ALIGN   8
L_052:  mov     ebx, 2
        mov     ebp, 3
        jmp     L_048





ALIGN   8
L_053:  mov     ebx, 3
        mov     ebp, 4
        jmp     L_048





ALIGN   8
L_054:  mov     ebx, 4
        mov     ebp, 5
        jmp     L_048





ALIGN   8
L_055:  mov     ebx, 5
        mov     ebp, 6
        jmp     L_048





ALIGN   8
L_056:  mov     ebx, 6
        mov     ebp, 7
        jmp     L_048





ALIGN   8
L_057:  mov     ebx, 7
        mov     ebp, 8
        jmp     L_048





ALIGN   8
L_058:  mov     ebx, 8
        mov     ebp, 9
        jmp     L_048

L_059:

        call    __stack_chk_fail



SECTION .data   


SECTION .bss    


SECTION .text.unlikely 


SECTION .rodata.str1.1 

L_060:
        db 25H, 73H, 00H


