global main

extern malloc
section .text

main:
main..main.entry:
	push rbp
	mov rbp,rsp
	sub rsp,336
	mov r8,___string
	mov qword [rbp-32],r8
	mov r8,qword [___resultCount]
	mov qword [rbp-168],r8
	mov r8,qword [___N]
	mov qword [rbp-160],r8
	mov r8,qword [___b]
	mov qword [rbp-24],r8
	mov r8,___string
	mov qword [rbp-224],r8
	mov qword [rbp-272],r8
	mov qword [rbp-280],r9
	call __init
	mov r9,qword [rbp-280]
	mov r8,qword [rbp-272]
	mov r8,qword [___b]
	mov qword [rbp-24],r8
	mov r8,qword [___N]
	mov qword [rbp-160],r8
	mov r8,qword [___resultCount]
	mov qword [rbp-168],r8
	mov r8,0
	mov qword [rbp-248],r8
	mov r8,1
	mov qword [rbp-248],r8
	jmp main..for_cond
main..for_cond:
	mov r8,qword [rbp-248]
	mov r9,qword [rbp-160]
	cmp r8,r9
	mov r10,0
	setle r10b
	mov qword [rbp-56],r10
	mov r8,qword [rbp-56]
	cmp r8,1
	jz main..for_loop
	jnz main..for_after
main..for_after:
	mov r8,2
	mov qword [rbp-248],r8
	jmp main..for_cond_2
main..for_cond_2:
	mov r8,qword [rbp-248]
	mov r9,qword [rbp-160]
	cmp r8,r9
	mov r10,0
	setle r10b
	mov qword [rbp-256],r10
	mov r8,qword [rbp-256]
	cmp r8,1
	jz main..for_loop_2
	jnz main..for_after_2
main..for_after_2:
	mov qword [rbp-264],r10
	mov qword [rbp-272],r8
	mov qword [rbp-280],r9
	mov rdi,qword [rbp-224]
	call _print
	mov r9,qword [rbp-280]
	mov r8,qword [rbp-272]
	mov r10,qword [rbp-264]
	mov qword [rbp-264],r10
	mov qword [rbp-272],r8
	mov qword [rbp-280],r9
	mov rdi,qword [rbp-168]
	call __printlnint
	mov r9,qword [rbp-280]
	mov r8,qword [rbp-272]
	mov r10,qword [rbp-264]
	mov rax,0
	leave
	ret
main..for_loop_2:
	mov r8,qword [rbp-248]
	mov r9,r8
	mov qword [rbp-64],r9
	mov r8,qword [rbp-248]
	imul r8,1
	mov qword [rbp-248],r8
	mov r8,qword [rbp-248]
	mov r9,r8
	mov qword [rbp-240],r9
	mov r8,qword [rbp-64]
	mov r9,r8
	mov qword [rbp-248],r9
	mov r8,qword [rbp-24]
	mov r9,qword [rbp-240]
	add r9,r8
	mov qword [rbp-240],r9
	mov r8,qword [rbp-240]
	mov r8,qword [r8+8]
	mov qword [rbp-240],r8
	mov r8,qword [rbp-240]
	cmp r8,1
	jz main..if_true
	jnz main..if_after
main..if_after:
	jmp main..for_step
main..for_step:
	mov r8,qword [rbp-248]
	mov r9,r8
	mov qword [rbp-88],r9
	mov r8,qword [rbp-248]
	add r8,1
	mov qword [rbp-248],r8
	jmp main..for_cond_2
main..if_true:
	mov r8,2
	mov qword [rbp-16],r8
	mov r8,qword [rbp-248]
	cmp r8,3
	mov r9,0
	setg r9b
	mov qword [rbp-176],r9
	mov r8,qword [rbp-176]
	cmp r8,1
	jz main..lhs_true
	jnz main..lhs_false
main..lhs_true:
	mov r8,qword [rbp-248]
	mov r9,r8
	mov qword [rbp-208],r9
	mov r8,qword [rbp-248]
	sub r8,2
	mov qword [rbp-248],r8
	mov r8,qword [rbp-248]
	mov r9,r8
	mov qword [rbp-40],r9
	mov r8,qword [rbp-208]
	mov r9,r8
	mov qword [rbp-248],r9
	mov r8,qword [rbp-40]
	mov r9,r8
	mov qword [rbp-8],r9
	mov r8,qword [rbp-40]
	imul r8,1
	mov qword [rbp-40],r8
	mov r8,qword [rbp-40]
	mov r9,r8
	mov qword [rbp-96],r9
	mov r8,qword [rbp-8]
	mov r9,r8
	mov qword [rbp-40],r9
	mov r8,qword [rbp-24]
	mov r9,qword [rbp-96]
	add r9,r8
	mov qword [rbp-96],r9
	mov r8,qword [rbp-96]
	mov r8,qword [r8+8]
	mov qword [rbp-96],r8
	mov r8,qword [rbp-96]
	mov r9,r8
	mov qword [rbp-112],r9
	jmp main..lhs_merge
main..lhs_false:
	mov r8,0
	mov qword [rbp-112],r8
	jmp main..lhs_merge
main..lhs_merge:
	mov r8,qword [rbp-112]
	cmp r8,1
	jz main..if_true_2
	jnz main..if_after_2
main..if_true_2:
	mov r8,qword [rbp-168]
	mov r9,r8
	mov qword [rbp-128],r9
	mov r8,qword [rbp-168]
	add r8,1
	mov qword [rbp-168],r8
	mov r8,qword [rbp-248]
	mov r9,r8
	mov qword [rbp-152],r9
	mov r8,qword [rbp-248]
	sub r8,2
	mov qword [rbp-248],r8
	mov r8,qword [rbp-248]
	mov r9,r8
	mov qword [rbp-120],r9
	mov r8,qword [rbp-152]
	mov r9,r8
	mov qword [rbp-248],r9
	mov qword [rbp-264],r10
	mov qword [rbp-272],r8
	mov qword [rbp-280],r9
	mov rdi,qword [rbp-120]
	call __printint
	mov r9,qword [rbp-280]
	mov r8,qword [rbp-272]
	mov r10,qword [rbp-264]
	mov qword [rbp-264],r10
	mov qword [rbp-272],r8
	mov qword [rbp-280],r9
	mov rdi,qword [rbp-32]
	call _print
	mov r9,qword [rbp-280]
	mov r8,qword [rbp-272]
	mov r10,qword [rbp-264]
	mov qword [rbp-264],r10
	mov qword [rbp-272],r8
	mov qword [rbp-280],r9
	mov rdi,qword [rbp-248]
	call __printlnint
	mov r9,qword [rbp-280]
	mov r8,qword [rbp-272]
	mov r10,qword [rbp-264]
	jmp main..if_after_2
main..if_after_2:
	jmp main..while_cond
main..while_cond:
	mov r8,qword [rbp-248]
	mov r9,r8
	mov qword [rbp-192],r9
	mov r8,qword [rbp-16]
	mov r9,qword [rbp-248]
	imul r9,r8
	mov qword [rbp-248],r9
	mov r8,qword [rbp-248]
	mov r9,r8
	mov qword [rbp-48],r9
	mov r8,qword [rbp-192]
	mov r9,r8
	mov qword [rbp-248],r9
	mov r8,qword [rbp-48]
	mov r9,qword [rbp-160]
	cmp r8,r9
	mov r10,0
	setle r10b
	mov qword [rbp-232],r10
	mov r8,qword [rbp-232]
	cmp r8,1
	jz main..while_loop
	jnz main..while_after
main..while_after:
main..while_loop:
	mov r8,qword [rbp-248]
	mov r9,r8
	mov qword [rbp-80],r9
	mov r8,qword [rbp-16]
	mov r9,qword [rbp-248]
	imul r9,r8
	mov qword [rbp-248],r9
	mov r8,qword [rbp-248]
	mov r9,r8
	mov qword [rbp-200],r9
	mov r8,qword [rbp-80]
	mov r9,r8
	mov qword [rbp-248],r9
	mov r8,qword [rbp-200]
	mov r9,r8
	mov qword [rbp-184],r9
	mov r8,qword [rbp-200]
	imul r8,1
	mov qword [rbp-200],r8
	mov r8,qword [rbp-200]
	mov r9,r8
	mov qword [rbp-144],r9
	mov r8,qword [rbp-184]
	mov r9,r8
	mov qword [rbp-200],r9
	mov r8,qword [rbp-24]
	mov r9,qword [rbp-144]
	add r9,r8
	mov qword [rbp-144],r9
	mov r8,qword [rbp-144]
	mov qword [r8+8],0
	mov r8,qword [rbp-16]
	mov r9,r8
	mov qword [rbp-72],r9
	mov r8,qword [rbp-16]
	add r8,1
	mov qword [rbp-16],r8
	jmp main..while_cond
main..for_loop:
	mov r8,qword [rbp-248]
	mov r9,r8
	mov qword [rbp-216],r9
	mov r8,qword [rbp-248]
	imul r8,1
	mov qword [rbp-248],r8
	mov r8,qword [rbp-248]
	mov r9,r8
	mov qword [rbp-104],r9
	mov r8,qword [rbp-216]
	mov r9,r8
	mov qword [rbp-248],r9
	mov r8,qword [rbp-24]
	mov r9,qword [rbp-104]
	add r9,r8
	mov qword [rbp-104],r9
	mov r8,qword [rbp-104]
	mov qword [r8+8],1
	jmp main..for_step_2
main..for_step_2:
	mov r8,qword [rbp-248]
	mov r9,r8
	mov qword [rbp-136],r9
	mov r8,qword [rbp-248]
	add r8,1
	mov qword [rbp-248],r8
	jmp main..for_cond

__init:
__init.._init.entry:
	push rbp
	mov rbp,rsp
	sub rsp,96
	mov r8,qword [___resultCount]
	mov qword [rbp-16],r8
	mov r8,qword [___N]
	mov qword [rbp-32],r8
	mov r8,qword [___b]
	mov qword [rbp-8],r8
	mov r8,15000
	mov qword [rbp-32],r8
	mov r8,15009
	mov qword [rbp-24],r8
	mov r8,qword [rbp-24]
	mov rdi,r8
	call malloc
	mov r8,rax
	mov qword [rbp-24],r8
	mov r8,qword [rbp-24]
	mov qword [r8],15001
	mov r8,qword [rbp-24]
	mov r9,r8
	mov qword [rbp-8],r9
	mov r8,0
	mov qword [rbp-16],r8
	mov r8,qword [rbp-16]
	mov qword [___resultCount],r8
	mov r8,qword [rbp-32]
	mov qword [___N],r8
	mov r8,qword [rbp-8]
	mov qword [___b],r8
	leave
	ret

	section .data
___string:
	dq 1," ",0
___string_2:
	dq 7,"Total: ",0

section .bss
___N:
	resb 64
___b:
	resb 64
___resultCount:
	resb 64






default rel

global _toString

extern __stack_chk_fail
extern malloc


SECTION .text 

_toString:
        push    rbp
        push    rbx
        sub     rsp, 72


        mov     rax, qword [fs:abs 28H]
        mov     qword [rsp+38H], rax
        xor     eax, eax
        test    edi, edi
        js      L_002
        jne     L_005
        mov     edi, 9
        call    malloc
        movzx   ebx, byte [rsp]
        mov     qword [rax], 1
        mov     byte [rax+9H], 0
        lea     edx, [rbx+30H]
        mov     byte [rax+8H], dl
L_001:  mov     rbx, qword [rsp+38H]


        xor     rbx, qword [fs:abs 28H]
        jne     L_015
        add     rsp, 72
        pop     rbx
        pop     rbp
        ret





ALIGN   8
L_002:  neg     edi
        mov     r9d, 1
L_003:  mov     eax, edi
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
        je      L_006
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
        je      L_007
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
        je      L_008
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
        je      L_009
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
        je      L_010
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
        je      L_011
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
        je      L_012
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
        je      L_013
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
        je      L_014
        mov     dword [rsp+28H], edx
        mov     ebx, 9
        mov     ebp, 10
L_004:  lea     edi, [r9+rbp+8H]
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
        je      L_001
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-2H]
        cmp     ecx, -1
        je      L_001
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-3H]
        cmp     ecx, -1
        je      L_001
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-4H]
        cmp     ecx, -1
        je      L_001
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-5H]
        cmp     ecx, -1
        je      L_001
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-6H]
        cmp     ecx, -1
        je      L_001
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-7H]
        cmp     ecx, -1
        je      L_001
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-8H]
        cmp     ecx, -1
        je      L_001
        movsxd  rcx, ecx
        movzx   esi, byte [rsp+rcx*4]
        add     esi, 48
        cmp     ebx, 8
        mov     byte [rax+rcx+8H], sil
        je      L_001
        movzx   ebx, byte [rsp]
        lea     edx, [rbx+30H]
        mov     byte [rax+8H], dl
        jmp     L_001






ALIGN   16
L_005:  xor     r9d, r9d
        jmp     L_003





ALIGN   16
L_006:  xor     ebx, ebx
        mov     ebp, 1
        jmp     L_004





ALIGN   8
L_007:  mov     ebx, 1
        mov     ebp, 2
        jmp     L_004





ALIGN   8
L_008:  mov     ebx, 2
        mov     ebp, 3
        jmp     L_004





ALIGN   8
L_009:  mov     ebx, 3
        mov     ebp, 4
        jmp     L_004





ALIGN   8
L_010:  mov     ebx, 4
        mov     ebp, 5
        jmp     L_004





ALIGN   8
L_011:  mov     ebx, 5
        mov     ebp, 6
        jmp     L_004





ALIGN   8
L_012:  mov     ebx, 6
        mov     ebp, 7
        jmp     L_004





ALIGN   8
L_013:  mov     ebx, 7
        mov     ebp, 8
        jmp     L_004





ALIGN   8
L_014:  mov     ebx, 8
        mov     ebp, 9
        jmp     L_004

L_015:

        call    __stack_chk_fail



SECTION .data   


SECTION .bss    


SECTION .text.unlikely 








default rel

global _print

extern __printf_chk


SECTION .text

_print:
        lea     rdx, [rdi+8H]
        mov     esi, L_001
        mov     edi, 1
        xor     eax, eax
        jmp     __printf_chk



SECTION .data   


SECTION .bss    


SECTION .rodata.str1.1 

L_001:
        db 25H, 73H, 00H


SECTION .text.unlikely 







default rel

global _println

extern puts


SECTION .text 

_println:
        add     rdi, 8
        jmp     puts



SECTION .data   


SECTION .bss    


SECTION .text.unlikely 







default rel

global _printInt

extern __stack_chk_fail
extern _IO_putc
extern stdout


SECTION .text

_printInt:
        push    rbx
        sub     rsp, 48


        mov     rax, qword [fs:abs 28H]
        mov     qword [rsp+28H], rax
        xor     eax, eax
        test    edi, edi
        je      L_004
        mov     ebx, edi
        js      L_005
L_001:  mov     eax, ebx
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
        mov     dword [rsp+4H], edi
        mov     edi, 1374389535
        imul    edi
        sar     edx, 5
        mov     edi, edx
        sub     edi, ecx
        je      L_010
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
        je      L_011
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
        je      L_006
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
        je      L_007
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
        je      L_008
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
        je      L_009
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
        je      L_013
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
        je      L_014
        mov     dword [rsp+24H], edx
        mov     ebx, 10
L_002:  sub     ebx, 1




ALIGN   8
L_003:  movsxd  rax, ebx
        mov     rsi, qword [rel stdout]
        sub     ebx, 1
        mov     edi, dword [rsp+rax*4]
        add     edi, 48
        call    _IO_putc
        cmp     ebx, -1
        jnz     L_003
        mov     rax, qword [rsp+28H]


        xor     rax, qword [fs:abs 28H]
        jne     L_015
        add     rsp, 48
        pop     rbx
        ret





ALIGN   8
L_004:  mov     rax, qword [rsp+28H]


        xor     rax, qword [fs:abs 28H]
        jne     L_015
        mov     rsi, qword [rel stdout]
        add     rsp, 48
        mov     edi, 48
        pop     rbx
        jmp     _IO_putc





ALIGN   8
L_005:  mov     rsi, qword [rel stdout]
        mov     edi, 45
        neg     ebx
        call    _IO_putc
        jmp     L_001

L_006:  mov     ebx, 4
        jmp     L_002

L_007:  mov     ebx, 5
        jmp     L_002

L_008:  mov     ebx, 6
        jmp     L_002

L_009:  mov     ebx, 7
        jmp     L_002

L_010:  mov     ebx, 2
        jmp     L_002

L_011:  mov     ebx, 3
        jmp     L_002

L_012:  mov     ebx, 1
        jmp     L_002

L_013:  mov     ebx, 8
        jmp     L_002

L_014:  mov     ebx, 9
        jmp     L_002

L_015:

        call    __stack_chk_fail



SECTION .data   


SECTION .bss    


SECTION .text.unlikely 







default rel

global _printlnInt

extern __stack_chk_fail
extern _IO_putc
extern stdout


SECTION .text

_printlnInt:
        push    rbx
        sub     rsp, 48


        mov     rax, qword [fs:abs 28H]
        mov     qword [rsp+28H], rax
        xor     eax, eax
        test    edi, edi
        je      L_005
        mov     ebx, edi
        js      L_006
L_001:  mov     eax, ebx
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
        mov     dword [rsp+4H], edi
        mov     edi, 1374389535
        imul    edi
        sar     edx, 5
        mov     edi, edx
        sub     edi, ecx
        je      L_011
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
        mov     dword [rsp+0CH], edi
        mov     edi, 1759218605
        imul    edi
        sar     edx, 12
        mov     edi, edx
        sub     edi, ecx
        je      L_007
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
        je      L_008
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
        je      L_009
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
        je      L_010
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
        je      L_014
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
        je      L_015
        mov     dword [rsp+24H], edx
        mov     ebx, 10
L_002:  sub     ebx, 1




ALIGN   8
L_003:  movsxd  rax, ebx
        mov     rsi, qword [rel stdout]
        sub     ebx, 1
        mov     edi, dword [rsp+rax*4]
        add     edi, 48
        call    _IO_putc
        cmp     ebx, -1
        jnz     L_003
L_004:  mov     rax, qword [rsp+28H]


        xor     rax, qword [fs:abs 28H]
        jne     L_016
        mov     rsi, qword [rel stdout]
        add     rsp, 48
        mov     edi, 10
        pop     rbx
        jmp     _IO_putc





ALIGN   8
L_005:  mov     rsi, qword [rel stdout]
        mov     edi, 48
        call    _IO_putc
        jmp     L_004





ALIGN   8
L_006:  mov     rsi, qword [rel stdout]
        mov     edi, 45
        neg     ebx
        call    _IO_putc
        jmp     L_001

L_007:  mov     ebx, 4
        jmp     L_002

L_008:  mov     ebx, 5
        jmp     L_002

L_009:  mov     ebx, 6
        jmp     L_002

L_010:  mov     ebx, 7
        jmp     L_002

L_011:  mov     ebx, 2
        jmp     L_002

L_012:  mov     ebx, 3
        jmp     L_002

L_013:  mov     ebx, 1
        jmp     L_002

L_014:  mov     ebx, 8
        jmp     L_002

L_015:  mov     ebx, 9
        jmp     L_002

L_016:

        call    __stack_chk_fail



SECTION .data   


SECTION .bss    


SECTION .text.unlikely 

