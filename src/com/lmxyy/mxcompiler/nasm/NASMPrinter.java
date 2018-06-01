package com.lmxyy.mxcompiler.nasm;

import com.lmxyy.mxcompiler.ir.*;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NASMPrinter implements IRVisitor {
    private PrintStream out;
    private Set<BasicBlock> BBVisited = new HashSet<>();
    private Map<BasicBlock, String> labelMap = new HashMap<>();
    private Map<StaticData, String> dataMap = new HashMap<>();
    private Map<String, Integer> counterBB = new HashMap<>();

    public NASMPrinter(PrintStream _out) {
        out = _out;
    }
    private String newId(String name,Map<String,Integer> counter) {
        int cnt = counter.getOrDefault(name,0)+1;
        counter.put(name,cnt);
        if (cnt == 1) return name;
        else return name+"_"+cnt;
    }

    private String labelId(BasicBlock basicBlock) {
        String id = labelMap.get(basicBlock);
        if (id == null) {
            id = newId(basicBlock.getParent().getConvertedName()+".."+basicBlock.getHintName(), counterBB);
            labelMap.put(basicBlock, id);
        }
        return id;
    }
    private String dataId(StaticData data) {
        String id = dataMap.get(data);
        if (id == null) {
            id = newId(data.getHintName(), counterBB);
            dataMap.put(data, id);
        }
        return id;
    }

    private void printBuiltinFunctions() {
        out.println("\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "default rel\n" +
                "\n" +
                "global _Z15stringSubStringPcii\n" +
                "global _Z14stringParseIntPc\n" +
                "global _Z12stringConcatPcS_\n" +
                "global _Z9stringEquPcS_\n" +
                "global _Z10stringLessPcS_\n" +
                "global _Z9stringLeqPcS_\n" +
                "global _Z5printPc\n" +
                "global _Z7printlnPc\n" +
                "global _Z8printInti\n" +
                "global _Z10printlnInti\n" +
                "global _Z9getStringv\n" +
                "global _Z6getIntv\n" +
                "global _Z8toStringi\n" +
                "\n" +
                "extern _IO_getc\n" +
                "extern stdin\n" +
                "extern scanf\n" +
                "extern __stack_chk_fail\n" +
                "extern _IO_putc\n" +
                "extern stdout\n" +
                "extern puts\n" +
                "extern __printf_chk\n" +
                "extern strcmp\n" +
                "extern memcpy\n" +
                "extern malloc\n" +
                "\n" +
                "\n" +
                "SECTION .text \n" +
                "\n" +
                "_Z15stringSubStringPcii:\n" +
                "        push    r15\n" +
                "        push    r14\n" +
                "        push    r13\n" +
                "        movsxd  r13, esi\n" +
                "        push    r12\n" +
                "        push    rbp\n" +
                "        push    rbx\n" +
                "        mov     ebx, edx\n" +
                "        sub     ebx, r13d\n" +
                "        mov     r12, rdi\n" +
                "        lea     edi, [rbx+0AH]\n" +
                "        lea     r15d, [rbx+1H]\n" +
                "        sub     rsp, 8\n" +
                "        movsxd  rdi, edi\n" +
                "        movsxd  r14, r15d\n" +
                "        call    malloc\n" +
                "        test    r15d, r15d\n" +
                "        mov     rbp, rax\n" +
                "        mov     qword [rax], r14\n" +
                "        jle     L_001\n" +
                "        mov     edx, ebx\n" +
                "        lea     rdi, [rax+8H]\n" +
                "        lea     rsi, [r12+r13+8H]\n" +
                "        add     rdx, 1\n" +
                "        call    memcpy\n" +
                "L_001:  mov     byte [rbp+r14+8H], 0\n" +
                "        add     rsp, 8\n" +
                "        mov     rax, rbp\n" +
                "        pop     rbx\n" +
                "        pop     rbp\n" +
                "        pop     r12\n" +
                "        pop     r13\n" +
                "        pop     r14\n" +
                "        pop     r15\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   16\n" +
                "\n" +
                "_Z14stringParseIntPc:\n" +
                "        xor     edx, edx\n" +
                "        cmp     byte [rdi+8H], 45\n" +
                "        sete    dl\n" +
                "        setne   r8b\n" +
                "        sete    al\n" +
                "        movsx   edx, byte [rdi+rdx+8H]\n" +
                "        movzx   r8d, r8b\n" +
                "        movzx   eax, al\n" +
                "        lea     r8d, [r8+r8-1H]\n" +
                "        lea     ecx, [rdx-30H]\n" +
                "        cmp     cl, 9\n" +
                "        ja      L_003\n" +
                "        lea     rcx, [rdi+rax+9H]\n" +
                "        xor     eax, eax\n" +
                "L_002:  lea     esi, [rax+rax*4]\n" +
                "        add     rcx, 1\n" +
                "        lea     eax, [rdx+rsi*2-30H]\n" +
                "        movsx   edx, byte [rcx-1H]\n" +
                "        lea     esi, [rdx-30H]\n" +
                "        cmp     sil, 9\n" +
                "        jbe     L_002\n" +
                "        imul    eax, r8d\n" +
                "        ret\n" +
                "\n" +
                "L_003:  xor     eax, eax\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "_Z12stringConcatPcS_:\n" +
                "        push    r15\n" +
                "        push    r14\n" +
                "        push    r13\n" +
                "        push    r12\n" +
                "        mov     r13, rsi\n" +
                "        push    rbp\n" +
                "        push    rbx\n" +
                "        sub     rsp, 24\n" +
                "        mov     rbx, qword [rdi]\n" +
                "        mov     rbp, qword [rsi]\n" +
                "        mov     qword [rsp+8H], rdi\n" +
                "        lea     r15d, [rbp+rbx]\n" +
                "        lea     edi, [r15+9H]\n" +
                "        movsxd  r15, r15d\n" +
                "        movsxd  rdi, edi\n" +
                "        call    malloc\n" +
                "        test    ebx, ebx\n" +
                "        mov     r12, rax\n" +
                "        mov     qword [rax], r15\n" +
                "        mov     rcx, qword [rsp+8H]\n" +
                "        jle     L_006\n" +
                "        lea     edx, [rbx-1H]\n" +
                "        lea     rdi, [rax+8H]\n" +
                "        lea     rsi, [rcx+8H]\n" +
                "        mov     r14d, ebx\n" +
                "        movsxd  rbx, ebx\n" +
                "        add     rdx, 1\n" +
                "        call    memcpy\n" +
                "L_004:  test    ebp, ebp\n" +
                "        jle     L_005\n" +
                "        movsxd  rax, r14d\n" +
                "        lea     edx, [rbp-1H]\n" +
                "        lea     ebx, [r14+rbp]\n" +
                "        lea     rdi, [r12+rax+8H]\n" +
                "        lea     rsi, [r13+8H]\n" +
                "        add     rdx, 1\n" +
                "        movsxd  rbx, ebx\n" +
                "        call    memcpy\n" +
                "L_005:  mov     byte [r12+rbx+8H], 0\n" +
                "        add     rsp, 24\n" +
                "        mov     rax, r12\n" +
                "        pop     rbx\n" +
                "        pop     rbp\n" +
                "        pop     r12\n" +
                "        pop     r13\n" +
                "        pop     r14\n" +
                "        pop     r15\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   8\n" +
                "L_006:  xor     ebx, ebx\n" +
                "        xor     r14d, r14d\n" +
                "        jmp     L_004\n" +
                "\n" +
                "\n" +
                "        nop\n" +
                "\n" +
                "ALIGN   16\n" +
                "_Z9stringEquPcS_:\n" +
                "        sub     rsp, 8\n" +
                "        add     rsi, 8\n" +
                "        add     rdi, 8\n" +
                "        call    strcmp\n" +
                "        test    eax, eax\n" +
                "        sete    al\n" +
                "        add     rsp, 8\n" +
                "        movzx   eax, al\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   8\n" +
                "\n" +
                "_Z10stringLessPcS_:\n" +
                "        sub     rsp, 8\n" +
                "        add     rsi, 8\n" +
                "        add     rdi, 8\n" +
                "        call    strcmp\n" +
                "        add     rsp, 8\n" +
                "        shr     eax, 31\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   8\n" +
                "\n" +
                "_Z9stringLeqPcS_:\n" +
                "        sub     rsp, 8\n" +
                "        add     rsi, 8\n" +
                "        add     rdi, 8\n" +
                "        call    strcmp\n" +
                "        test    eax, eax\n" +
                "        setle   al\n" +
                "        add     rsp, 8\n" +
                "        movzx   eax, al\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   8\n" +
                "\n" +
                "_Z5printPc:\n" +
                "        lea     rdx, [rdi+8H]\n" +
                "        mov     esi, L_060\n" +
                "        mov     edi, 1\n" +
                "        xor     eax, eax\n" +
                "        jmp     __printf_chk\n" +
                "\n" +
                "\n" +
                "        nop\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   16\n" +
                "\n" +
                "_Z7printlnPc:\n" +
                "        add     rdi, 8\n" +
                "        jmp     puts\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   8\n" +
                "\n" +
                "_Z8printInti:\n" +
                "        push    rbx\n" +
                "        sub     rsp, 48\n" +
                "\n" +
                "\n" +
                "        mov     rax, qword [fs:abs 28H]\n" +
                "        mov     qword [rsp+28H], rax\n" +
                "        xor     eax, eax\n" +
                "        test    edi, edi\n" +
                "        je      L_010\n" +
                "        mov     ebx, edi\n" +
                "        js      L_011\n" +
                "L_007:  mov     eax, ebx\n" +
                "        mov     esi, 1717986919\n" +
                "        mov     ecx, ebx\n" +
                "        imul    esi\n" +
                "        sar     ecx, 31\n" +
                "        sar     edx, 2\n" +
                "        sub     edx, ecx\n" +
                "        lea     eax, [rdx+rdx*4]\n" +
                "        mov     edi, edx\n" +
                "        mov     edx, ebx\n" +
                "        add     eax, eax\n" +
                "        sub     edx, eax\n" +
                "        test    edi, edi\n" +
                "        mov     dword [rsp], edx\n" +
                "        je      L_018\n" +
                "        mov     eax, edi\n" +
                "        imul    esi\n" +
                "        mov     eax, edi\n" +
                "        sar     eax, 31\n" +
                "        sar     edx, 2\n" +
                "        sub     edx, eax\n" +
                "        lea     eax, [rdx+rdx*4]\n" +
                "        add     eax, eax\n" +
                "        sub     edi, eax\n" +
                "        mov     eax, ebx\n" +
                "        mov     dword [rsp+4H], edi\n" +
                "        mov     edi, 1374389535\n" +
                "        imul    edi\n" +
                "        sar     edx, 5\n" +
                "        mov     edi, edx\n" +
                "        sub     edi, ecx\n" +
                "        je      L_016\n" +
                "        mov     eax, edi\n" +
                "        imul    esi\n" +
                "        mov     eax, edi\n" +
                "        sar     eax, 31\n" +
                "        sar     edx, 2\n" +
                "        sub     edx, eax\n" +
                "        lea     eax, [rdx+rdx*4]\n" +
                "        add     eax, eax\n" +
                "        sub     edi, eax\n" +
                "        mov     eax, ebx\n" +
                "        mov     dword [rsp+8H], edi\n" +
                "        mov     edi, 274877907\n" +
                "        imul    edi\n" +
                "        sar     edx, 6\n" +
                "        mov     edi, edx\n" +
                "        sub     edi, ecx\n" +
                "        je      L_017\n" +
                "        mov     eax, edi\n" +
                "        imul    esi\n" +
                "        mov     eax, edi\n" +
                "        sar     eax, 31\n" +
                "        sar     edx, 2\n" +
                "        sub     edx, eax\n" +
                "        lea     eax, [rdx+rdx*4]\n" +
                "        add     eax, eax\n" +
                "        sub     edi, eax\n" +
                "        mov     eax, ebx\n" +
                "        mov     dword [rsp+0CH], edi\n" +
                "        mov     edi, 1759218605\n" +
                "        imul    edi\n" +
                "        sar     edx, 12\n" +
                "        mov     edi, edx\n" +
                "        sub     edi, ecx\n" +
                "        je      L_012\n" +
                "        mov     eax, edi\n" +
                "        imul    esi\n" +
                "        mov     eax, edi\n" +
                "        sar     eax, 31\n" +
                "        sar     edx, 2\n" +
                "        sub     edx, eax\n" +
                "        lea     eax, [rdx+rdx*4]\n" +
                "        add     eax, eax\n" +
                "        sub     edi, eax\n" +
                "        mov     eax, ebx\n" +
                "        mov     dword [rsp+10H], edi\n" +
                "        mov     edi, 351843721\n" +
                "        imul    edi\n" +
                "        sar     edx, 13\n" +
                "        mov     edi, edx\n" +
                "        sub     edi, ecx\n" +
                "        je      L_013\n" +
                "        mov     eax, edi\n" +
                "        imul    esi\n" +
                "        mov     eax, edi\n" +
                "        sar     eax, 31\n" +
                "        sar     edx, 2\n" +
                "        sub     edx, eax\n" +
                "        lea     eax, [rdx+rdx*4]\n" +
                "        add     eax, eax\n" +
                "        sub     edi, eax\n" +
                "        mov     eax, ebx\n" +
                "        mov     dword [rsp+14H], edi\n" +
                "        mov     edi, 1125899907\n" +
                "        imul    edi\n" +
                "        sar     edx, 18\n" +
                "        mov     edi, edx\n" +
                "        sub     edi, ecx\n" +
                "        je      L_014\n" +
                "        mov     eax, edi\n" +
                "        imul    esi\n" +
                "        mov     eax, edi\n" +
                "        sar     eax, 31\n" +
                "        sar     edx, 2\n" +
                "        sub     edx, eax\n" +
                "        lea     eax, [rdx+rdx*4]\n" +
                "        add     eax, eax\n" +
                "        sub     edi, eax\n" +
                "        mov     eax, ebx\n" +
                "        mov     dword [rsp+18H], edi\n" +
                "        mov     edi, 1801439851\n" +
                "        imul    edi\n" +
                "        sar     edx, 22\n" +
                "        mov     edi, edx\n" +
                "        sub     edi, ecx\n" +
                "        je      L_015\n" +
                "        mov     eax, edi\n" +
                "        imul    esi\n" +
                "        mov     eax, edi\n" +
                "        sar     eax, 31\n" +
                "        sar     edx, 2\n" +
                "        sub     edx, eax\n" +
                "        lea     eax, [rdx+rdx*4]\n" +
                "        add     eax, eax\n" +
                "        sub     edi, eax\n" +
                "        mov     eax, ebx\n" +
                "        mov     dword [rsp+1CH], edi\n" +
                "        mov     edi, 1441151881\n" +
                "        imul    edi\n" +
                "        sar     edx, 25\n" +
                "        mov     edi, edx\n" +
                "        sub     edi, ecx\n" +
                "        je      L_019\n" +
                "        mov     eax, edi\n" +
                "        imul    esi\n" +
                "        mov     eax, edi\n" +
                "        sar     eax, 31\n" +
                "        mov     esi, edx\n" +
                "        mov     edx, 1152921505\n" +
                "        sar     esi, 2\n" +
                "        sub     esi, eax\n" +
                "        lea     eax, [rsi+rsi*4]\n" +
                "        add     eax, eax\n" +
                "        sub     edi, eax\n" +
                "        mov     eax, ebx\n" +
                "        imul    edx\n" +
                "        mov     dword [rsp+20H], edi\n" +
                "        sar     edx, 28\n" +
                "        sub     edx, ecx\n" +
                "        je      L_020\n" +
                "        mov     dword [rsp+24H], edx\n" +
                "        mov     ebx, 10\n" +
                "L_008:  sub     ebx, 1\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   8\n" +
                "L_009:  movsxd  rax, ebx\n" +
                "        mov     rsi, qword [rel stdout]\n" +
                "        sub     ebx, 1\n" +
                "        mov     edi, dword [rsp+rax*4]\n" +
                "        add     edi, 48\n" +
                "        call    _IO_putc\n" +
                "        cmp     ebx, -1\n" +
                "        jnz     L_009\n" +
                "        mov     rax, qword [rsp+28H]\n" +
                "\n" +
                "\n" +
                "        xor     rax, qword [fs:abs 28H]\n" +
                "        jne     L_021\n" +
                "        add     rsp, 48\n" +
                "        pop     rbx\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   8\n" +
                "L_010:  mov     rax, qword [rsp+28H]\n" +
                "\n" +
                "\n" +
                "        xor     rax, qword [fs:abs 28H]\n" +
                "        jne     L_021\n" +
                "        mov     rsi, qword [rel stdout]\n" +
                "        add     rsp, 48\n" +
                "        mov     edi, 48\n" +
                "        pop     rbx\n" +
                "        jmp     _IO_putc\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   8\n" +
                "L_011:  mov     rsi, qword [rel stdout]\n" +
                "        mov     edi, 45\n" +
                "        neg     ebx\n" +
                "        call    _IO_putc\n" +
                "        jmp     L_007\n" +
                "\n" +
                "L_012:  mov     ebx, 4\n" +
                "        jmp     L_008\n" +
                "\n" +
                "L_013:  mov     ebx, 5\n" +
                "        jmp     L_008\n" +
                "\n" +
                "L_014:  mov     ebx, 6\n" +
                "        jmp     L_008\n" +
                "\n" +
                "L_015:  mov     ebx, 7\n" +
                "        jmp     L_008\n" +
                "\n" +
                "L_016:  mov     ebx, 2\n" +
                "        jmp     L_008\n" +
                "\n" +
                "L_017:  mov     ebx, 3\n" +
                "        jmp     L_008\n" +
                "\n" +
                "L_018:  mov     ebx, 1\n" +
                "        jmp     L_008\n" +
                "\n" +
                "L_019:  mov     ebx, 8\n" +
                "        jmp     L_008\n" +
                "\n" +
                "L_020:  mov     ebx, 9\n" +
                "        jmp     L_008\n" +
                "\n" +
                "L_021:  call    __stack_chk_fail\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   16\n" +
                "\n" +
                "_Z10printlnInti:\n" +
                "        push    rbx\n" +
                "        sub     rsp, 48\n" +
                "\n" +
                "\n" +
                "        mov     rax, qword [fs:abs 28H]\n" +
                "        mov     qword [rsp+28H], rax\n" +
                "        xor     eax, eax\n" +
                "        test    edi, edi\n" +
                "        je      L_026\n" +
                "        mov     ebx, edi\n" +
                "        js      L_027\n" +
                "L_022:  mov     eax, ebx\n" +
                "        mov     esi, 1717986919\n" +
                "        mov     ecx, ebx\n" +
                "        imul    esi\n" +
                "        sar     ecx, 31\n" +
                "        sar     edx, 2\n" +
                "        sub     edx, ecx\n" +
                "        lea     eax, [rdx+rdx*4]\n" +
                "        mov     edi, edx\n" +
                "        mov     edx, ebx\n" +
                "        add     eax, eax\n" +
                "        sub     edx, eax\n" +
                "        test    edi, edi\n" +
                "        mov     dword [rsp], edx\n" +
                "        je      L_034\n" +
                "        mov     eax, edi\n" +
                "        imul    esi\n" +
                "        mov     eax, edi\n" +
                "        sar     eax, 31\n" +
                "        sar     edx, 2\n" +
                "        sub     edx, eax\n" +
                "        lea     eax, [rdx+rdx*4]\n" +
                "        add     eax, eax\n" +
                "        sub     edi, eax\n" +
                "        mov     eax, ebx\n" +
                "        mov     dword [rsp+4H], edi\n" +
                "        mov     edi, 1374389535\n" +
                "        imul    edi\n" +
                "        sar     edx, 5\n" +
                "        mov     edi, edx\n" +
                "        sub     edi, ecx\n" +
                "        je      L_032\n" +
                "        mov     eax, edi\n" +
                "        imul    esi\n" +
                "        mov     eax, edi\n" +
                "        sar     eax, 31\n" +
                "        sar     edx, 2\n" +
                "        sub     edx, eax\n" +
                "        lea     eax, [rdx+rdx*4]\n" +
                "        add     eax, eax\n" +
                "        sub     edi, eax\n" +
                "        mov     eax, ebx\n" +
                "        mov     dword [rsp+8H], edi\n" +
                "        mov     edi, 274877907\n" +
                "        imul    edi\n" +
                "        sar     edx, 6\n" +
                "        mov     edi, edx\n" +
                "        sub     edi, ecx\n" +
                "        je      L_033\n" +
                "        mov     eax, edi\n" +
                "        imul    esi\n" +
                "        mov     eax, edi\n" +
                "        sar     eax, 31\n" +
                "        sar     edx, 2\n" +
                "        sub     edx, eax\n" +
                "        lea     eax, [rdx+rdx*4]\n" +
                "        add     eax, eax\n" +
                "        sub     edi, eax\n" +
                "        mov     eax, ebx\n" +
                "        mov     dword [rsp+0CH], edi\n" +
                "        mov     edi, 1759218605\n" +
                "        imul    edi\n" +
                "        sar     edx, 12\n" +
                "        mov     edi, edx\n" +
                "        sub     edi, ecx\n" +
                "        je      L_028\n" +
                "        mov     eax, edi\n" +
                "        imul    esi\n" +
                "        mov     eax, edi\n" +
                "        sar     eax, 31\n" +
                "        sar     edx, 2\n" +
                "        sub     edx, eax\n" +
                "        lea     eax, [rdx+rdx*4]\n" +
                "        add     eax, eax\n" +
                "        sub     edi, eax\n" +
                "        mov     eax, ebx\n" +
                "        mov     dword [rsp+10H], edi\n" +
                "        mov     edi, 351843721\n" +
                "        imul    edi\n" +
                "        sar     edx, 13\n" +
                "        mov     edi, edx\n" +
                "        sub     edi, ecx\n" +
                "        je      L_029\n" +
                "        mov     eax, edi\n" +
                "        imul    esi\n" +
                "        mov     eax, edi\n" +
                "        sar     eax, 31\n" +
                "        sar     edx, 2\n" +
                "        sub     edx, eax\n" +
                "        lea     eax, [rdx+rdx*4]\n" +
                "        add     eax, eax\n" +
                "        sub     edi, eax\n" +
                "        mov     eax, ebx\n" +
                "        mov     dword [rsp+14H], edi\n" +
                "        mov     edi, 1125899907\n" +
                "        imul    edi\n" +
                "        sar     edx, 18\n" +
                "        mov     edi, edx\n" +
                "        sub     edi, ecx\n" +
                "        je      L_030\n" +
                "        mov     eax, edi\n" +
                "        imul    esi\n" +
                "        mov     eax, edi\n" +
                "        sar     eax, 31\n" +
                "        sar     edx, 2\n" +
                "        sub     edx, eax\n" +
                "        lea     eax, [rdx+rdx*4]\n" +
                "        add     eax, eax\n" +
                "        sub     edi, eax\n" +
                "        mov     eax, ebx\n" +
                "        mov     dword [rsp+18H], edi\n" +
                "        mov     edi, 1801439851\n" +
                "        imul    edi\n" +
                "        sar     edx, 22\n" +
                "        mov     edi, edx\n" +
                "        sub     edi, ecx\n" +
                "        je      L_031\n" +
                "        mov     eax, edi\n" +
                "        imul    esi\n" +
                "        mov     eax, edi\n" +
                "        sar     eax, 31\n" +
                "        sar     edx, 2\n" +
                "        sub     edx, eax\n" +
                "        lea     eax, [rdx+rdx*4]\n" +
                "        add     eax, eax\n" +
                "        sub     edi, eax\n" +
                "        mov     eax, ebx\n" +
                "        mov     dword [rsp+1CH], edi\n" +
                "        mov     edi, 1441151881\n" +
                "        imul    edi\n" +
                "        sar     edx, 25\n" +
                "        mov     edi, edx\n" +
                "        sub     edi, ecx\n" +
                "        je      L_035\n" +
                "        mov     eax, edi\n" +
                "        imul    esi\n" +
                "        mov     eax, edi\n" +
                "        sar     eax, 31\n" +
                "        mov     esi, edx\n" +
                "        mov     edx, 1152921505\n" +
                "        sar     esi, 2\n" +
                "        sub     esi, eax\n" +
                "        lea     eax, [rsi+rsi*4]\n" +
                "        add     eax, eax\n" +
                "        sub     edi, eax\n" +
                "        mov     eax, ebx\n" +
                "        imul    edx\n" +
                "        mov     dword [rsp+20H], edi\n" +
                "        sar     edx, 28\n" +
                "        sub     edx, ecx\n" +
                "        je      L_036\n" +
                "        mov     dword [rsp+24H], edx\n" +
                "        mov     ebx, 10\n" +
                "L_023:  sub     ebx, 1\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   8\n" +
                "L_024:  movsxd  rax, ebx\n" +
                "        mov     rsi, qword [rel stdout]\n" +
                "        sub     ebx, 1\n" +
                "        mov     edi, dword [rsp+rax*4]\n" +
                "        add     edi, 48\n" +
                "        call    _IO_putc\n" +
                "        cmp     ebx, -1\n" +
                "        jnz     L_024\n" +
                "L_025:  mov     rax, qword [rsp+28H]\n" +
                "\n" +
                "\n" +
                "        xor     rax, qword [fs:abs 28H]\n" +
                "        jne     L_037\n" +
                "        mov     rsi, qword [rel stdout]\n" +
                "        add     rsp, 48\n" +
                "        mov     edi, 10\n" +
                "        pop     rbx\n" +
                "        jmp     _IO_putc\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   8\n" +
                "L_026:  mov     rsi, qword [rel stdout]\n" +
                "        mov     edi, 48\n" +
                "        call    _IO_putc\n" +
                "        jmp     L_025\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   8\n" +
                "L_027:  mov     rsi, qword [rel stdout]\n" +
                "        mov     edi, 45\n" +
                "        neg     ebx\n" +
                "        call    _IO_putc\n" +
                "        jmp     L_022\n" +
                "\n" +
                "L_028:  mov     ebx, 4\n" +
                "        jmp     L_023\n" +
                "\n" +
                "L_029:  mov     ebx, 5\n" +
                "        jmp     L_023\n" +
                "\n" +
                "L_030:  mov     ebx, 6\n" +
                "        jmp     L_023\n" +
                "\n" +
                "L_031:  mov     ebx, 7\n" +
                "        jmp     L_023\n" +
                "\n" +
                "L_032:  mov     ebx, 2\n" +
                "        jmp     L_023\n" +
                "\n" +
                "L_033:  mov     ebx, 3\n" +
                "        jmp     L_023\n" +
                "\n" +
                "L_034:  mov     ebx, 1\n" +
                "        jmp     L_023\n" +
                "\n" +
                "L_035:  mov     ebx, 8\n" +
                "        jmp     L_023\n" +
                "\n" +
                "L_036:  mov     ebx, 9\n" +
                "        jmp     L_023\n" +
                "\n" +
                "L_037:  call    __stack_chk_fail\n" +
                "        nop\n" +
                "ALIGN   16\n" +
                "\n" +
                "_Z9getStringv:\n" +
                "        push    rbp\n" +
                "        push    rbx\n" +
                "        mov     edi, 300\n" +
                "        sub     rsp, 8\n" +
                "        call    malloc\n" +
                "        lea     rbx, [rax+8H]\n" +
                "        mov     rbp, rax\n" +
                "        mov     edi, L_060\n" +
                "        xor     eax, eax\n" +
                "        mov     rsi, rbx\n" +
                "        call    scanf\n" +
                "        mov     rdx, rbx\n" +
                "L_038:  mov     ecx, dword [rdx]\n" +
                "        add     rdx, 4\n" +
                "        lea     eax, [rcx-1010101H]\n" +
                "        not     ecx\n" +
                "        and     eax, ecx\n" +
                "        and     eax, 80808080H\n" +
                "        jz      L_038\n" +
                "        mov     ecx, eax\n" +
                "        shr     ecx, 16\n" +
                "        test    eax, 8080H\n" +
                "        cmove   eax, ecx\n" +
                "        lea     rcx, [rdx+2H]\n" +
                "        mov     esi, eax\n" +
                "        cmove   rdx, rcx\n" +
                "        add     sil, al\n" +
                "        mov     rax, rbp\n" +
                "        sbb     rdx, 3\n" +
                "        sub     rdx, rbx\n" +
                "        mov     qword [rbp], rdx\n" +
                "        add     rsp, 8\n" +
                "        pop     rbx\n" +
                "        pop     rbp\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "        nop\n" +
                "\n" +
                "ALIGN   16\n" +
                "_Z6getIntv:\n" +
                "        push    rbp\n" +
                "        push    rbx\n" +
                "        sub     rsp, 8\n" +
                "        jmp     L_040\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   16\n" +
                "L_039:  cmp     al, 45\n" +
                "        jz      L_041\n" +
                "L_040:  mov     rdi, qword [rel stdin]\n" +
                "        call    _IO_getc\n" +
                "        lea     ecx, [rax-30H]\n" +
                "        movsx   edx, al\n" +
                "        cmp     cl, 9\n" +
                "        ja      L_039\n" +
                "L_041:  cmp     dl, 45\n" +
                "        mov     ebp, 1\n" +
                "        jz      L_044\n" +
                "L_042:  xor     ebx, ebx\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   16\n" +
                "L_043:  mov     rdi, qword [rel stdin]\n" +
                "        lea     eax, [rbx+rbx*4]\n" +
                "        lea     ebx, [rdx+rax*2-30H]\n" +
                "        call    _IO_getc\n" +
                "        movsx   edx, al\n" +
                "        sub     eax, 48\n" +
                "        cmp     al, 9\n" +
                "        jbe     L_043\n" +
                "        mov     eax, ebx\n" +
                "        add     rsp, 8\n" +
                "        imul    eax, ebp\n" +
                "        pop     rbx\n" +
                "        pop     rbp\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   8\n" +
                "L_044:  mov     rdi, qword [rel stdin]\n" +
                "        mov     ebp, 4294967295\n" +
                "        call    _IO_getc\n" +
                "        movsx   edx, al\n" +
                "        jmp     L_042\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   16\n" +
                "\n" +
                "_Z8toStringi:\n" +
                "        push    rbp\n" +
                "        push    rbx\n" +
                "        sub     rsp, 72\n" +
                "\n" +
                "\n" +
                "        mov     rax, qword [fs:abs 28H]\n" +
                "        mov     qword [rsp+38H], rax\n" +
                "        xor     eax, eax\n" +
                "        test    edi, edi\n" +
                "        js      L_046\n" +
                "        jne     L_049\n" +
                "        mov     edi, 10\n" +
                "        call    malloc\n" +
                "        movzx   ebx, byte [rsp]\n" +
                "        mov     qword [rax], 1\n" +
                "        mov     byte [rax+9H], 0\n" +
                "        lea     edx, [rbx+30H]\n" +
                "        mov     byte [rax+8H], dl\n" +
                "L_045:  mov     rbx, qword [rsp+38H]\n" +
                "\n" +
                "\n" +
                "        xor     rbx, qword [fs:abs 28H]\n" +
                "        jne     L_059\n" +
                "        add     rsp, 72\n" +
                "        pop     rbx\n" +
                "        pop     rbp\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   8\n" +
                "L_046:  neg     edi\n" +
                "        mov     r9d, 1\n" +
                "L_047:  mov     eax, edi\n" +
                "        mov     esi, 1717986919\n" +
                "        mov     ecx, edi\n" +
                "        imul    esi\n" +
                "        sar     ecx, 31\n" +
                "        mov     ebx, edi\n" +
                "        sar     edx, 2\n" +
                "        sub     edx, ecx\n" +
                "        lea     eax, [rdx+rdx*4]\n" +
                "        mov     r8d, edx\n" +
                "        add     eax, eax\n" +
                "        sub     ebx, eax\n" +
                "        test    edx, edx\n" +
                "        mov     dword [rsp+4H], ebx\n" +
                "        je      L_050\n" +
                "        mov     eax, edx\n" +
                "        imul    esi\n" +
                "        mov     eax, r8d\n" +
                "        sar     eax, 31\n" +
                "        sar     edx, 2\n" +
                "        sub     edx, eax\n" +
                "        lea     eax, [rdx+rdx*4]\n" +
                "        add     eax, eax\n" +
                "        sub     r8d, eax\n" +
                "        mov     eax, edi\n" +
                "        mov     dword [rsp+8H], r8d\n" +
                "        mov     r8d, 1374389535\n" +
                "        imul    r8d\n" +
                "        sar     edx, 5\n" +
                "        mov     r8d, edx\n" +
                "        sub     r8d, ecx\n" +
                "        je      L_051\n" +
                "        mov     eax, r8d\n" +
                "        imul    esi\n" +
                "        mov     eax, r8d\n" +
                "        sar     eax, 31\n" +
                "        sar     edx, 2\n" +
                "        sub     edx, eax\n" +
                "        lea     eax, [rdx+rdx*4]\n" +
                "        add     eax, eax\n" +
                "        sub     r8d, eax\n" +
                "        mov     eax, edi\n" +
                "        mov     dword [rsp+0CH], r8d\n" +
                "        mov     r8d, 274877907\n" +
                "        imul    r8d\n" +
                "        sar     edx, 6\n" +
                "        mov     r8d, edx\n" +
                "        sub     r8d, ecx\n" +
                "        je      L_052\n" +
                "        mov     eax, r8d\n" +
                "        imul    esi\n" +
                "        mov     eax, r8d\n" +
                "        sar     eax, 31\n" +
                "        sar     edx, 2\n" +
                "        sub     edx, eax\n" +
                "        lea     eax, [rdx+rdx*4]\n" +
                "        add     eax, eax\n" +
                "        sub     r8d, eax\n" +
                "        mov     eax, edi\n" +
                "        mov     dword [rsp+10H], r8d\n" +
                "        mov     r8d, 1759218605\n" +
                "        imul    r8d\n" +
                "        sar     edx, 12\n" +
                "        mov     r8d, edx\n" +
                "        sub     r8d, ecx\n" +
                "        je      L_053\n" +
                "        mov     eax, r8d\n" +
                "        imul    esi\n" +
                "        mov     eax, r8d\n" +
                "        sar     eax, 31\n" +
                "        sar     edx, 2\n" +
                "        sub     edx, eax\n" +
                "        lea     eax, [rdx+rdx*4]\n" +
                "        add     eax, eax\n" +
                "        sub     r8d, eax\n" +
                "        mov     eax, edi\n" +
                "        mov     dword [rsp+14H], r8d\n" +
                "        mov     r8d, 351843721\n" +
                "        imul    r8d\n" +
                "        sar     edx, 13\n" +
                "        mov     r8d, edx\n" +
                "        sub     r8d, ecx\n" +
                "        je      L_054\n" +
                "        mov     eax, r8d\n" +
                "        imul    esi\n" +
                "        mov     eax, r8d\n" +
                "        sar     eax, 31\n" +
                "        sar     edx, 2\n" +
                "        sub     edx, eax\n" +
                "        lea     eax, [rdx+rdx*4]\n" +
                "        add     eax, eax\n" +
                "        sub     r8d, eax\n" +
                "        mov     eax, edi\n" +
                "        mov     dword [rsp+18H], r8d\n" +
                "        mov     r8d, 1125899907\n" +
                "        imul    r8d\n" +
                "        sar     edx, 18\n" +
                "        mov     r8d, edx\n" +
                "        sub     r8d, ecx\n" +
                "        je      L_055\n" +
                "        mov     eax, r8d\n" +
                "        imul    esi\n" +
                "        mov     eax, r8d\n" +
                "        sar     eax, 31\n" +
                "        sar     edx, 2\n" +
                "        sub     edx, eax\n" +
                "        lea     eax, [rdx+rdx*4]\n" +
                "        add     eax, eax\n" +
                "        sub     r8d, eax\n" +
                "        mov     eax, edi\n" +
                "        mov     dword [rsp+1CH], r8d\n" +
                "        mov     r8d, 1801439851\n" +
                "        imul    r8d\n" +
                "        sar     edx, 22\n" +
                "        mov     r8d, edx\n" +
                "        sub     r8d, ecx\n" +
                "        je      L_056\n" +
                "        mov     eax, r8d\n" +
                "        imul    esi\n" +
                "        mov     eax, r8d\n" +
                "        sar     eax, 31\n" +
                "        sar     edx, 2\n" +
                "        sub     edx, eax\n" +
                "        lea     eax, [rdx+rdx*4]\n" +
                "        add     eax, eax\n" +
                "        sub     r8d, eax\n" +
                "        mov     eax, edi\n" +
                "        mov     dword [rsp+20H], r8d\n" +
                "        mov     r8d, 1441151881\n" +
                "        imul    r8d\n" +
                "        sar     edx, 25\n" +
                "        mov     r8d, edx\n" +
                "        sub     r8d, ecx\n" +
                "        je      L_057\n" +
                "        mov     eax, r8d\n" +
                "        imul    esi\n" +
                "        mov     eax, r8d\n" +
                "        sar     eax, 31\n" +
                "        mov     esi, edx\n" +
                "        mov     edx, 1152921505\n" +
                "        sar     esi, 2\n" +
                "        sub     esi, eax\n" +
                "        lea     eax, [rsi+rsi*4]\n" +
                "        add     eax, eax\n" +
                "        sub     r8d, eax\n" +
                "        mov     eax, edi\n" +
                "        imul    edx\n" +
                "        mov     dword [rsp+24H], r8d\n" +
                "        sar     edx, 28\n" +
                "        sub     edx, ecx\n" +
                "        je      L_058\n" +
                "        mov     dword [rsp+28H], edx\n" +
                "        mov     ebx, 9\n" +
                "        mov     ebp, 10\n" +
                "L_048:  lea     edi, [r9+rbp+9H]\n" +
                "        movsxd  rdi, edi\n" +
                "        call    malloc\n" +
                "        movsxd  rsi, ebx\n" +
                "        mov     qword [rax], rbp\n" +
                "        mov     byte [rax+rbp+8H], 0\n" +
                "        movzx   edi, byte [rsp+rsi*4]\n" +
                "        lea     ecx, [rdi+30H]\n" +
                "        mov     byte [rax+rsi+8H], cl\n" +
                "        lea     ecx, [rbx-1H]\n" +
                "        cmp     ecx, -1\n" +
                "        je      L_045\n" +
                "        movsxd  rcx, ecx\n" +
                "        movzx   edi, byte [rsp+rcx*4]\n" +
                "        lea     esi, [rdi+30H]\n" +
                "        mov     byte [rax+rcx+8H], sil\n" +
                "        lea     ecx, [rbx-2H]\n" +
                "        cmp     ecx, -1\n" +
                "        je      L_045\n" +
                "        movsxd  rcx, ecx\n" +
                "        movzx   edi, byte [rsp+rcx*4]\n" +
                "        lea     esi, [rdi+30H]\n" +
                "        mov     byte [rax+rcx+8H], sil\n" +
                "        lea     ecx, [rbx-3H]\n" +
                "        cmp     ecx, -1\n" +
                "        je      L_045\n" +
                "        movsxd  rcx, ecx\n" +
                "        movzx   edi, byte [rsp+rcx*4]\n" +
                "        lea     esi, [rdi+30H]\n" +
                "        mov     byte [rax+rcx+8H], sil\n" +
                "        lea     ecx, [rbx-4H]\n" +
                "        cmp     ecx, -1\n" +
                "        je      L_045\n" +
                "        movsxd  rcx, ecx\n" +
                "        movzx   edi, byte [rsp+rcx*4]\n" +
                "        lea     esi, [rdi+30H]\n" +
                "        mov     byte [rax+rcx+8H], sil\n" +
                "        lea     ecx, [rbx-5H]\n" +
                "        cmp     ecx, -1\n" +
                "        je      L_045\n" +
                "        movsxd  rcx, ecx\n" +
                "        movzx   edi, byte [rsp+rcx*4]\n" +
                "        lea     esi, [rdi+30H]\n" +
                "        mov     byte [rax+rcx+8H], sil\n" +
                "        lea     ecx, [rbx-6H]\n" +
                "        cmp     ecx, -1\n" +
                "        je      L_045\n" +
                "        movsxd  rcx, ecx\n" +
                "        movzx   edi, byte [rsp+rcx*4]\n" +
                "        lea     esi, [rdi+30H]\n" +
                "        mov     byte [rax+rcx+8H], sil\n" +
                "        lea     ecx, [rbx-7H]\n" +
                "        cmp     ecx, -1\n" +
                "        je      L_045\n" +
                "        movsxd  rcx, ecx\n" +
                "        movzx   edi, byte [rsp+rcx*4]\n" +
                "        lea     esi, [rdi+30H]\n" +
                "        mov     byte [rax+rcx+8H], sil\n" +
                "        lea     ecx, [rbx-8H]\n" +
                "        cmp     ecx, -1\n" +
                "        je      L_045\n" +
                "        movsxd  rcx, ecx\n" +
                "        movzx   esi, byte [rsp+rcx*4]\n" +
                "        add     esi, 48\n" +
                "        cmp     ebx, 8\n" +
                "        mov     byte [rax+rcx+8H], sil\n" +
                "        je      L_045\n" +
                "        movzx   ebx, byte [rsp]\n" +
                "        lea     edx, [rbx+30H]\n" +
                "        mov     byte [rax+8H], dl\n" +
                "        jmp     L_045\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   16\n" +
                "L_049:  xor     r9d, r9d\n" +
                "        jmp     L_047\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   16\n" +
                "L_050:  xor     ebx, ebx\n" +
                "        mov     ebp, 1\n" +
                "        jmp     L_048\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   8\n" +
                "L_051:  mov     ebx, 1\n" +
                "        mov     ebp, 2\n" +
                "        jmp     L_048\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   8\n" +
                "L_052:  mov     ebx, 2\n" +
                "        mov     ebp, 3\n" +
                "        jmp     L_048\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   8\n" +
                "L_053:  mov     ebx, 3\n" +
                "        mov     ebp, 4\n" +
                "        jmp     L_048\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   8\n" +
                "L_054:  mov     ebx, 4\n" +
                "        mov     ebp, 5\n" +
                "        jmp     L_048\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   8\n" +
                "L_055:  mov     ebx, 5\n" +
                "        mov     ebp, 6\n" +
                "        jmp     L_048\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   8\n" +
                "L_056:  mov     ebx, 6\n" +
                "        mov     ebp, 7\n" +
                "        jmp     L_048\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   8\n" +
                "L_057:  mov     ebx, 7\n" +
                "        mov     ebp, 8\n" +
                "        jmp     L_048\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALIGN   8\n" +
                "L_058:  mov     ebx, 8\n" +
                "        mov     ebp, 9\n" +
                "        jmp     L_048\n" +
                "\n" +
                "L_059:\n" +
                "\n" +
                "        call    __stack_chk_fail\n" +
                "\n" +
                "\n" +
                "\n" +
                "SECTION .data   \n" +
                "\n" +
                "\n" +
                "SECTION .bss    \n" +
                "\n" +
                "\n" +
                "SECTION .text.unlikely \n" +
                "\n" +
                "\n" +
                "SECTION .rodata.str1.1 \n" +
                "\n" +
                "L_060:\n" +
                "        db 25H, 73H, 00H\n" +
                "\n");
    }

    @Override
    public void visit(IRRoot node) {
        out.println("global main\n");

        out.println("extern malloc");
//        out.println("\textern puts");
//        out.println("\textern __stack_chk_fail");

        out.println("section .text");
        node.functions.values().forEach(func->func.accept(this));
        /* Static String */
        out.println("\n\tsection .data");
        node.stringPool.forEach((a,b)->{
            out.println("___"+dataId(b)+":");
            String s = "";
            for (int i = 0;i < a.length();++i) {
                if (a.charAt(i) == '\\') {
                    if (a.charAt(i+1) == 'n') {
                        s = s+'\n';
                    }
                    else if (a.charAt(i+1) == '\\') {
                        s = s+'\\';
                    }
                    else s = s+'\"';
                    ++i;
                }
                else s = s+a.charAt(i);
            }
            out.print("\tdb 0,0,0,0,0,0,0,"+(s.length()));
            for (int i = 0;i < s.length();++i) {
                out.print(","+(int)(s.charAt(i)));
            }
            out.println(",0");
        });
        out.println("\nsection .bss");
        node.dataList.forEach(data->{
            out.println("___"+dataId(data)+":");
            out.println("\tresb "+data.getRegisterSize()*8);
        });
        printBuiltinFunctions();
    }

    @Override
    public void visit(BasicBlock node) {
        if (BBVisited.contains(node)) return;
        BBVisited.add(node);
        out.println(labelId(node)+":");
        for (IRInstruction inst = node.getHead();inst != null;inst = inst.getNxt()) {
            inst.accept(this);
        }
    }

    @Override
    public void visit(Function node) {
        out.println('\n'+node.getConvertedName()+":");
        node.getReversePostOrder().forEach(basicBlock->visit(basicBlock));
    }

    @Override
    public void visit(ArithmeticInstruction node) {
        if (node.getOperator() == BinaryOperationInstruction.Operator.DIV
                || node.getOperator() == BinaryOperationInstruction.Operator.MOD) {
            out.print("\tidiv ");
            node.getRhs().accept(this);
            out.print('\n');
        }
        else {
            System.err.println("Reach the thress address instruction.");
            assert false;
        }
    }

    @Override
    public void visit(UnaryOperationInstruction node) {
        out.print("\t");
        if (node.getOperator() == UnaryOperationInstruction.Operator.NEG) {
            out.print("neg ");
        }
        else if (node.getOperator() == UnaryOperationInstruction.Operator.COMP) {
            out.print("not ");
        }
        else {
            System.err.println("Get a strange operator.");
            assert false;
        }
        node.getOprand().accept(this);
        out.print('\n');
    }

    @Override
    public void visit(ComparisionInstruction node) {
        out.print("\tcmp ");
        node.getLhs().accept(this);
        out.print(',');
        node.getRhs().accept(this);
        out.print("\n");
        out.print("\tmov ");
        node.getDest().accept(this);
        out.print(",0");
        out.print("\n\t");
        switch (node.getOperator()) {
            case EQU:
                out.print("sete ");
                break;
            case NEQ:
                out.print("setne ");
                break;
            case LESS:
                out.print("setl ");
                break;
            case LEQ:
                out.print("setle ");
                break;
            case GRTR:
                out.print("setg ");
                break;
            case GEQ:
                out.print("setge ");
                break;
            default: System.err.println("Unknown comparision operator."); break;
        }
        ((NASMRegister)node.getDest()).setFlag(true);
        node.getDest().accept(this);
        ((NASMRegister)node.getDest()).setFlag(false);
        out.print("\n");
    }

    @Override
    public void visit(CallInstruction node) {
        out.println("\tcall "+node.getFunction().getConvertedName());
    }

    @Override
    public void visit(BranchInstruction node) {
        out.print("\tcmp ");
        if (node.getIndicator() instanceof NASMRegister) {
            ((NASMRegister) node.getIndicator()).setFlag(true);
        }
        node.getIndicator().accept(this);
        if (node.getIndicator() instanceof NASMRegister) {
            ((NASMRegister) node.getIndicator()).setFlag(false);
        }
        out.println(",1");
        out.println("\tjz "+labelId(node.getIfTrue()));
        out.println("\tjnz "+labelId(node.getIfFalse()));
    }

    @Override
    public void visit(HeapAllocateInstruction node) {
        out.println("\tcall malloc");
    }

    @Override
    public void visit(JumpInstruction node) {
        out.println("\tjmp "+labelId(node.getTarget()));
    }

    @Override
    public void visit(LoadInstruction node) {
//        if (node.getSize() == 1) {
//            out.print("\tmov ");
//            node.getDest().accept(this);
//            out.println(",0");
//        }
        out.print("\tmov ");
        ((NASMRegister) node.getDest()).setFlag(node.getSize() == 1);
        node.getDest().accept(this);
        ((NASMRegister) node.getDest()).setFlag(false);
        if (node.getAddr() instanceof StaticString)
            out.print(",");
        else if (node.getSize() == 1) out.print(",byte [");
        else out.print(",qword [");
        node.getAddr().accept(this);
        if (node.getOffset() > 0) out.print('+');
        if (node.getOffset() != 0) out.print(node.getOffset());
        if (node.getAddr() instanceof StaticString)
            out.print("\n");
        else out.print("]\n");
    }

    @Override
    public void visit(MoveInstruction node) {
        out.print("\tmov ");
        node.getDest().accept(this);
        out.print(',');
        node.getSource().accept(this);
        out.print('\n');
    }

    @Override
    public void visit(StoreInstruction node) {
        if (node.getSize() == 1)
            out.print("\tmov byte [");
        else out.print("\tmov qword [");
        node.getAddr().accept(this);
        if (node.getOffset() > 0) out.print('+');
        if (node.getOffset() != 0) out.print(node.getOffset());
        out.print("],");
        if (node.getValue() instanceof NASMRegister) {
            ((NASMRegister)node.getValue()).setFlag(node.getSize() == 1);
        }
        node.getValue().accept(this);
        if (node.getValue() instanceof NASMRegister) {
            ((NASMRegister)node.getValue()).setFlag(false);
        }
        out.print('\n');
    }

    @Override
    public void visit(ReturnInstruction node) {
        out.println("\tret");
    }

    @Override
    public void visit(TwoAddressInstruction node) {
        out.print('\t');
        switch (node.getOperator()) {
            case ADD:
                out.print("add ");
                node.getLhs().accept(this);
                out.print(',');
                node.getRhs().accept(this);
                break;
            case SUB:
                out.print("sub ");
                node.getLhs().accept(this);
                out.print(',');
                node.getRhs().accept(this);
                break;
            case MUL:
                out.print("imul ");
                node.getLhs().accept(this);
                out.print(',');
                node.getRhs().accept(this);
                break;
            case DIV: case MOD:
                out.print("idiv ");
                node.getRhs().accept(this);
                break;
            case XOR:
                out.print("xor ");
                node.getLhs().accept(this);
                out.print(',');
                node.getRhs().accept(this);
                break;
            case OR:
                out.print("or ");
                node.getLhs().accept(this);
                out.print(',');
                node.getRhs().accept(this);
                break;
            case AND:
                out.print("and ");
                node.getLhs().accept(this);
                out.print(',');
                node.getRhs().accept(this);
                break;
            case SHL:
                out.print("sal ");
                node.getLhs().accept(this);
                out.print(',');
                node.getRhs().accept(this);
                break;
            case SHR:
                out.print("sar ");
                node.getLhs().accept(this);
                out.print(',');
                node.getRhs().accept(this);
                break;
            default: System.err.println("Unknown operator in two address operation."); break;
        }
        out.print('\n');
    }

    @Override
    public void visit(PushInstruction node) {
        out.print("\tpush ");
        if (node.isAddress()) {
            out.print("qword [");
            node.getOprand().accept(this);
            if (node.getOffset() > 0) out.print('+');
            out.print(node.getOffset());
            out.print(']');
        }
        else {
            node.getOprand().accept(this);
        }
        out.print('\n');
    }

    @Override
    public void visit(PopInstruction node) {
        // nothing to do here, cannot be here.
        System.err.println("Invalid pop instruction.");
        assert false;
    }

    @Override
    public void visit(LeaveInstruction node) {
        out.println("\tleave");
    }

    @Override
    public void visit(CqoInstruction node) {
        out.println("\tcqo");
    }

    @Override
    public void visit(VirtualRegister node) {
        System.err.println("Virtual registers still exist.");
        assert false;
    }

    @Override
    public void visit(PhysicalRegister node) {
        node.accept(this);
    }

    @Override
    public void visit(NASMRegister node) {
        out.print(node.getName());
    }

    @Override
    public void visit(StaticSpace node) {
        out.print("___"+dataId(node));
    }

    @Override
    public void visit(StaticString node) {
        out.print("___"+dataId(node));
    }

    @Override
    public void visit(IntImmediate node) {
        out.print(node.getVal());
    }

    @Override
    public void visit(StackSlot node) {
        // nothing to do here, cannot be here.
        System.err.println("Stack slots do not exist.");
        assert false;
    }
}
