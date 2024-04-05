先说一句：你要时不时记得按“Shift+F10”运行下测试
1. 封装变量 (InvoiceLine)
    * 光标移至变量product（或其它成员）
    * Ctrl+Alt+Shift+T -> Encapsulate Fields
    * 同时勾选其它欲封装变量，执行
2. 拆分变量 (InvoiceLine.setQuantity 中 sum)
    1. 光标框选：第二次赋值的sum，及其相关部分
    2. Ctrl+Atl+M: 提取为一个新函数。目的：将sum变量的两个目的分解开
    3. 就当前例子，较为简单，可采用Ctrl+Alt+N (Inline)，把函数进一步简化
3. 移动语句 + 提炼函数 （InvoiceLine中计算amount和taxAmount逻辑）
    * 更新price/taxRate为getPrice()/getTaxRate() 
    * 框选 setAmount() 和 setTaxAmount() 紧接出现的部分
    * Ctrl+Alt+M: 提取为一个新函数，命名为 updateAmounts()
4. 移除设值函数 (InvoiceLine.setXxx)
    * Ctrl+Alt+N: setAmount(), setTaxAmount() 
5. 查询取代派生变量 (InvoiceLine amount & taxAmount)
    * Alt+Shift+Arrow: 将updateAmounts()中相关代码移至getAmount()&getTaxAmount()
    * Ctrl+Alt+N: updateAmounts()
    * Ctrl+Y: 删除amount & taxAmount
6. Builder模式创建不可变对象
    1. 将InvoiceLine默认构造的调用替换，并删除该构造函数
    2. Refactor/Replace Constructor as Builder
    3. Ctrl+Alt+N: setXxx
    4. Alt + Enter: Remove redundant initializer 
    5. Alt + Enter: make final 
    
7. 增加构造变量(Invoice())
    1. 选中new ArrayList<>, Ctrl+Alt+P，新增参数
    2. 依赖接口而非实现，将变量类型改为List
8. 将Invoice变为不可变类
    1. 可考虑Builder模式（参考上述步骤6，此例不演示）
    2. 不考虑Builder模式
        1. 修改构造中lines采用拷贝的方式
        2. 删除putLine方法（Atl+Del），并修改相关调用
9. 引用对象改为值对象(Invoice.getLines)
    1. 添加遗漏的测试 InvoiceTest.should_adding_line_fail_when_using_get_lines
    2. 修改返回值为不可变对象
    
10. 最后检查下代码
    1. Ctrl+Enter: 将Invoice下部分lambda简化
    