先说一句：你要时不时记得按“Shift+F10”运行下测试
# 案例1
1. 函数功能整理与分割 - 多功能for循环功能分割
    1. 复制一个for循环
    2. 删除功能，每个for循环只做一件事情
    3. 将for循环相关的临时变量移动语句到一起
    4. 将分割的功能移动到合适的位置，计算总价的for循环移到打印Total语句的前面
2. 对print函数进行函数提炼
    1. 提炼（CTRL+ALT+m）函数printHeader
    2. 提炼函数printDetail
    3. 提炼函数printFooter
3. printDetail进行重构
    1. 提炼函数printTableHeader
    2. 提炼函数printVoiceLines
4. printVoiceLines进行重构
    1. 临时变量过多，选中临时变量进行以查询取代临时变量（CTRL+ALT+N）
    2. 将amount的计算提炼函数并移动到InvoiceLine类中作为成员函数（删除static修饰，再F6），
    并使用CTRL+ALT+N直接取类成员变量值而不是get方法。最后amount使用查询取代该临时变量
    3. 条件表达式提炼函数isValid，并移动到InvoiceLine类中作为成员函数（删除static修饰，再F6），
    并使用CTRL+ALT+N直接取类成员变量值而不是get方法
5. printFooter进行重构
    1. 提炼函数calAmount并移动到Invoice类中作为成员函数，并将临时变量total以查询取代
    2. calAmount函数内部for循环复用InvoiceLine.getAmount函数,并以查询取代amount临时变量
6. 上述每次变更代码的操作都要时不时记得按“Shift+F10”运行下测试
7. IDEA的Code Check插件进行静态安全检查
# 案例2
1. 选中LOCAL分支语句块，提炼函数saveToLocal
2. 选中SFTP分支语句块，提炼函数saveToSftp
3. 选中EMAIL分支语句块，提炼函数saveToEmail
4. 选中HUAWEI_CLOUD分支语句块，提炼函数saveToHuaweiCloud
5. 选中BAIDU_CLOUD分支语句块，提炼函数saveToBaiduCloud
6. 上述每次变更代码的操作都要时不时记得按“Shift+F10”运行下测试
7. IDEA的Code Check插件进行静态安全检查

