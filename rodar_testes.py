import os
import glob
import xml.etree.ElementTree as etree


def checa_aps(pref):
    num_falhas = 0
    for f in glob.glob(f'target/surefire-reports/*{pref}.*.xml'):
        x = etree.parse(f)
        for tst in x.findall('testcase'):
            if tst.find('error') != None:
                num_falhas += 1
    
    return num_falhas


def identifica_aluno():
    with open('README.md') as f:
        for l in f.readlines():
            if l.startswith('NOME:'):
                return l[6:].strip()
    
    return ''


def roda_testes():
    os.system('mvn -fae test > mvn-output.txt')

if __name__ == '__main__':
    nome_aluno = identifica_aluno()
    print('Nome:', nome_aluno)

    roda_testes()

    for i in ['', 1, 2]:
        print(f'APS0{i}: ', checa_aps(f'aps0{i}'), 'falhas')
