<?php

use yii\db\Migration;

/**
 * Class m240524_100000_insert_test_user
 */
class m240524_100000_insert_test_user extends Migration
{
    /**
     * {@inheritdoc}
     */
    public function safeUp()
    {
        $this->insert('{{%user}}', [
            'username' => 'testuser',
            'auth_key' => Yii::$app->security->generateRandomString(),
            'password_hash' => Yii::$app->security->generatePasswordHash('testuser'),
            'email' => 'testuser@example.com',
            'created_at' => time(),
            'updated_at' => time(),
            'role' => 'user',
        ]);
    }

    /**
     * {@inheritdoc}
     */
    public function safeDown()
    {
        $this->delete('{{%user}}', ['username' => 'testuser']);
    }
}
